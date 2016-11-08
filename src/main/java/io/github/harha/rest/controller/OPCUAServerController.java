package io.github.harha.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.harha.rest.model.OPCUAServer;
import io.github.harha.rest.service.api.IOPCUAServerService;

@RestController
@RequestMapping("/opcuaservers")
public class OPCUAServerController {
	
	private static final Logger LOGGER = Logger.getLogger(OPCUAServerController.class.getName());
	
	@Autowired
	private IOPCUAServerService m_service;
	
	/*
	 * Returns a list of servers from the database.
	 * @param	endpoint	Query by server endpoint URL.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<OPCUAServer> getServers(
			@RequestParam(value = "endpoint", required = false) String endpoint
	) {
		LOGGER.log(Level.INFO, "getServers, endpoint: {0}", endpoint);
		List<OPCUAServer> results = new ArrayList<>();
		
		try {
			results = m_service.getServers(null, endpoint);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "getServers, exception while querying the service.", e);
		}
		
		return results;
	}
	
	/*
	 * Returns a list of servers from the database.
	 * @param	serverId	Query by serverId.
	 */
	@RequestMapping(method = RequestMethod.GET, value = "{serverId}")
	public @ResponseBody List<OPCUAServer> getServers(
			@PathVariable Integer serverId
	) {
		LOGGER.log(Level.INFO, "getServers, serverId: {0}", serverId);
		List<OPCUAServer> results = new ArrayList<>();
		
		try {
			results = m_service.getServers(serverId, null);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "getServers, exception while querying the service.", e);
		}
		
		return results;
	}
	
	/*
	 * Delete servers from the database.
	 * @param	endpoint	Query by server endpoint URL.
	 */
	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<?> deleteServers(
			@RequestParam(value = "endpoint", required = false) String endpoint
	) {
		LOGGER.log(Level.INFO, "deleteServers, endpoint: {0}", endpoint);
		ResponseEntity<String> result = new ResponseEntity<>(HttpStatus.OK);
		
		try {
			m_service.deleteServers(null, endpoint);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "deleteServers, exception while querying the service.", e);
			result = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return result;
	}
	
	/*
	 * Delete servers from the database.
	 * @param	serverId	Query by serverId.
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "{serverId}")
	public @ResponseBody ResponseEntity<?> deleteServers(
			@PathVariable Integer serverId
	) {
		LOGGER.log(Level.INFO, "deleteServers, serverId: {0}", serverId);
		ResponseEntity<String> result = new ResponseEntity<>(HttpStatus.OK);
		
		try {
			m_service.deleteServers(serverId, null);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "deleteServers, exception while querying the service.", e);
			result = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return result;
	}
	
	/*
	 * Inserts a single server into the database.
	 * @param	server	Object input instance.
	 */
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseEntity<?> insertServer(
			@RequestBody  OPCUAServer server
	) {
		LOGGER.log(Level.INFO, "insertServer, server: {0}", server);
		ResponseEntity<String> result = new ResponseEntity<>(HttpStatus.OK);
		
		try {
			m_service.insertServer(server);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "insertServer, exception while querying the service.", e);
			result = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return result;
	}
	
	/*
	 * Updates a single server in the database.
	 * @param	server	Object input instance.
	 */
	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
	public @ResponseBody ResponseEntity<?> updateServer(
			@RequestBody  OPCUAServer server
	) {
		LOGGER.log(Level.INFO, "updateServer, server: {0}", server);
		ResponseEntity<String> result = new ResponseEntity<>(HttpStatus.OK);
		
		try {
			m_service.updateServer(server);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "updateServer, exception while querying the service.", e);
			result = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return result;
	}

}
