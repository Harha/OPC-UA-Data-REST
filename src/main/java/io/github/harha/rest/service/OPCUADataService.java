package io.github.harha.rest.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.github.harha.rest.model.OPCUAServer;

public class OPCUADataService {
	
	// Class logger
	private static final Logger LOGGER = Logger.getLogger(OPCUADataService.class.getName());
	
	// Singleton instance
	private static OPCUADataService INSTANCE = null;
	
	private OPCUADataService() {
		LOGGER.log(Level.INFO, "OPCUADataService::OPCUADataService");
	}
	
	public static OPCUADataService getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new OPCUADataService();
		}
		
		return INSTANCE;
	}
	
	public Map<Integer, OPCUAServer> getServers(Integer id) {
		Map<Integer, OPCUAServer> results = new HashMap<>();
		results.put(0, new OPCUAServer(0, "localhost"));
		results.put(1, new OPCUAServer(1, "harha-laptop"));
		
		if (id == null)
			return results;
		
		Map<Integer, OPCUAServer> results_id = new HashMap<>();
		results_id.put(results.get(id).getId(), results.get(id));
		
		return results_id;
	}

}
