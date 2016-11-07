package io.github.harha.rest.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.harha.rest.api.OPCUAVariableRepository;
import io.github.harha.rest.model.OPCUAVariable;

@RestController
@RequestMapping("/opcuavariables")
public class OPCUAVariableController {
	
	private static final Logger LOGGER = Logger.getLogger(OPCUAVariableController.class.getName());
	
	@Autowired
	private OPCUAVariableRepository m_repository;
	
	/*
	 * Inserts a single variable into the repository.
	 * @param	variable	Object input instance.
	 */
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseEntity<?> insertVariable(
			@RequestBody  OPCUAVariable variable
	) {
		LOGGER.log(Level.INFO, "insertVariable, server: {0}", variable);
		
		ResponseEntity<String> result = new ResponseEntity<>(HttpStatus.OK);
		
		try {
			if (variable.containsNull()) {
				throw new Exception("Some mandatory input parameter(s) were null.");
			}
			
			m_repository.save(variable);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "insertVariable, exception while querying the repository.", e);
			
			result = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return result;
	}

}
