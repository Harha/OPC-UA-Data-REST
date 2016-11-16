package io.github.harha.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.harha.rest.model.OPCUAVariable;
import io.github.harha.rest.service.api.IOPCUAVariableService;

@RestController
@CrossOrigin
@RequestMapping("/opcuavariables")
public class OPCUAVariableController {
	
	private static final Logger LOGGER = Logger.getLogger(OPCUAVariableController.class.getName());
	
	@Autowired
	private IOPCUAVariableService m_service;
	
	/*
	 * Returns a list of variables from the database.
	 * @param	identifier			Query by subscription identifier
	 * @param	serverId			Query by subscription serverId
	 * @param	serverTimeStampFrom	Query by variable serverTimeStamp starting
	 * @param	serverTimeStampTo	Query by variable serverTimeStamp ending
	 */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<OPCUAVariable> getVariables(
			@RequestParam(value = "identifier", required = false) String identifier,
			@RequestParam(value = "serverId", required = false) Integer serverId,
			@RequestParam(value = "serverTimeStampFrom", required = false) @DateTimeFormat(iso = ISO.DATE_TIME) DateTime serverTimeStampFrom,
			@RequestParam(value = "serverTimeStampTo", required = false) @DateTimeFormat(iso = ISO.DATE_TIME) DateTime serverTimeStampTo
	) {
		LOGGER.log(Level.INFO, "getVariables, identifier: {0}, serverId: " + serverId + ", serverTimeStamp: " + serverTimeStampFrom, identifier);
		List<OPCUAVariable> results = new ArrayList<>();
		
		try {
			results = m_service.getVariables(null, identifier, serverId, serverTimeStampFrom, serverTimeStampTo);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "getVariables, exception while querying the service.", e);
		}
		
		return results;
	}
	
	/*
	 * Returns a list of variables from the database.
	 * @param	nsIndex	Query by subscription nsIndex
	 * @param	serverTimeStampFrom	Query by variable serverTimeStamp starting
	 * @param	serverTimeStampTo	Query by variable serverTimeStamp ending
	 */
	@RequestMapping(method = RequestMethod.GET, value = "{nsIndex}")
	public @ResponseBody List<OPCUAVariable> getVariables(
			@PathVariable Integer nsIndex,
			@RequestParam(value = "serverTimeStampFrom", required = false) @DateTimeFormat(iso = ISO.DATE_TIME) DateTime serverTimeStampFrom,
			@RequestParam(value = "serverTimeStampTo", required = false) @DateTimeFormat(iso = ISO.DATE_TIME) DateTime serverTimeStampTo
	) {
		LOGGER.log(Level.INFO, "getVariables, nsIndex: {0}, serverTimeStamp: " + serverTimeStampFrom, nsIndex);
		List<OPCUAVariable> results = new ArrayList<>();
		
		try {
			results = m_service.getVariables(nsIndex, null, null, serverTimeStampFrom, serverTimeStampTo);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "getVariables, exception while querying the service.", e);
		}
		
		return results;
	}
	
	/*
	 * Inserts a single variable into the database.
	 * @param	variable	Object input instance
	 */
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseEntity<?> insertVariable(
			@RequestBody OPCUAVariable variable
	) {
		LOGGER.log(Level.INFO, "insertVariable, server: {0}", variable);
		ResponseEntity<String> result = new ResponseEntity<>(HttpStatus.OK);
		
		try {
			m_service.insertVariable(variable);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "insertVariable, exception while querying the repository.", e);
			result = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return result;
	}

}
