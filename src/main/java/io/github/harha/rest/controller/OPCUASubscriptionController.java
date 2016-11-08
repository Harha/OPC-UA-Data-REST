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

import io.github.harha.rest.model.OPCUASubscription;
import io.github.harha.rest.service.api.IOPCUASubscriptionService;

@RestController
@RequestMapping("/opcuasubscriptions")
public class OPCUASubscriptionController {
	
	private static final Logger LOGGER = Logger.getLogger(OPCUASubscriptionController.class.getName());
	
	@Autowired
	private IOPCUASubscriptionService m_service;
	
	/*
	 * Returns a list of subscriptions from the database.
	 * @param	identifier	Query by subscription identifier
	 * @param	serverId	Query by subscription serverId
	 */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<OPCUASubscription> getSubscriptions(
			@RequestParam(value = "identifier", required = false) String identifier,
			@RequestParam(value = "serverId", required = false) Integer serverId
	) {
		LOGGER.log(Level.INFO, "getSubscriptions, identifier: {0}, serverId: " + serverId, identifier);
		List<OPCUASubscription> results = new ArrayList<>();
		
		try {
			results = m_service.getSubscriptions(null, identifier, serverId);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "getSubscriptions, exception while querying the service.", e);
		}
		
		return results;
	}
	
	/*
	 * Returns a list of subscriptions from the database.
	 * @param	nsIndex	Query by subscription nsIndex
	 */
	@RequestMapping(method = RequestMethod.GET, value = "{nsIndex}")
	public @ResponseBody List<OPCUASubscription> getSubscriptions(
			@PathVariable Integer nsIndex
	) {
		LOGGER.log(Level.INFO, "getSubscriptions, nsIndex: {0}", nsIndex);
		List<OPCUASubscription> results = new ArrayList<>();
		
		try {
			results = m_service.getSubscriptions(nsIndex, null, null);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "getSubscriptions, exception while querying the service.", e);
		}
		
		return results;
	}
	
	/*
	 * Delete subscriptions from the database.
	 */
	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<?> deleteSubscriptions() {
		LOGGER.log(Level.INFO, "deleteSubscriptions");
		ResponseEntity<String> result = new ResponseEntity<>(HttpStatus.OK);
		
		try {
			m_service.deleteSubscriptions(null, null, null);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "deleteSubscriptions, exception while querying the service.", e);
			result = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return result;
	}
	
	/*
	 * Inserts a single subscription into the database.
	 * @param	variable	Object input instance.
	 */
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseEntity<?> insertSubscription(
			@RequestBody  OPCUASubscription subscription
	) {
		LOGGER.log(Level.INFO, "insertSubscription, server: {0}", subscription);
		ResponseEntity<String> result = new ResponseEntity<>(HttpStatus.OK);
		
		try {
			m_service.insertSubscription(subscription);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "insertSubscription, exception while querying the service.", e);
			result = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return result;
	}

}
