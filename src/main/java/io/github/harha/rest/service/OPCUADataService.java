package io.github.harha.rest.service;

import java.util.logging.Level;
import java.util.logging.Logger;

public class OPCUADataService {
	
	private static final Logger LOGGER = Logger.getLogger(OPCUADataService.class.getName());
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

}
