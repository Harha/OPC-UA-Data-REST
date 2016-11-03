package io.github.harha.rest.controller;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.harha.rest.model.OPCUAServer;
import io.github.harha.rest.service.OPCUADataService;

@RestController
@RequestMapping("/opcuaservers")
public class OPCUAServerController {
	
	// Class logger
	private static final Logger LOGGER = Logger.getLogger(OPCUAServerController.class.getName());
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Map<Integer, OPCUAServer> getServers(
			HttpServletRequest request
	) {
		LOGGER.log(Level.INFO, "getServers");
		return OPCUADataService.getInstance().getServers(null);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public @ResponseBody Map<Integer, OPCUAServer> getServers(
			HttpServletRequest request,
			@PathVariable Integer id
	) {
		LOGGER.log(Level.INFO, "getServers, id:{0}", id);
		return OPCUADataService.getInstance().getServers(id);
	}

}
