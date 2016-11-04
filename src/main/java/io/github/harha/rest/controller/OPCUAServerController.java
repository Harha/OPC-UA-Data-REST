package io.github.harha.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.harha.rest.api.OPCUAServerRepository;
import io.github.harha.rest.model.OPCUAServer;

@RestController
@RequestMapping("/opcuaservers")
public class OPCUAServerController {
	
	private static final Logger LOGGER = Logger.getLogger(OPCUAServerController.class.getName());
	
	@Autowired
	private OPCUAServerRepository m_repository;
	
	/*
	 * Returns a list of all servers from the repository.
	 * @param	endpoint	Query by server endpoint URL.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<OPCUAServer> getServers(
			@RequestParam(value = "endpoint", required = false) String endpoint
	) {
		LOGGER.log(Level.INFO, "getServers, endpoint: {0}", endpoint);
		
		List<OPCUAServer> results = new ArrayList<>();
		
		try {
			if (endpoint == null)
				results = m_repository.findAll();
			else
				results = m_repository.findByEndpoint(endpoint);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "getServers, exception while querying the repository.", e);
		}
		
		return results;
	}
	
	/*
	 * Returns a single server from the repository by serverId.
	 */
	@RequestMapping(method = RequestMethod.GET, value = "{serverId}")
	public @ResponseBody OPCUAServer getServerByServerId(
			@PathVariable Integer serverId
	) {
		LOGGER.log(Level.INFO, "getServerByServerId, serverId: {0}", serverId);
		
		OPCUAServer result = null;
		
		try {
			result = m_repository.findByServerId(serverId);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "getServerByServerId, exception while querying the repository.", e);
		}
		
		return result;
	}
	
	/*
	 * Inserts a single server into the repository.
	 */
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseEntity<?> insertServer(
			@RequestBody OPCUAServer server
	) {
		LOGGER.log(Level.INFO, "insertServer, server: {0}", server);
		
		ResponseEntity<String> result = new ResponseEntity<>(HttpStatus.OK);
		
		try {
			if (server.getServerId() == null) {
				throw new Exception("Parameter serverId must not be null.");
			}
			
			if (m_repository.findByServerId(server.getServerId()) != null) {
				throw new Exception("a Server already exists in the database with given serverId.");
			}
			
			m_repository.save(server);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "insertServer, exception while querying the repository.", e);
			
			result = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return result;
	}

}
