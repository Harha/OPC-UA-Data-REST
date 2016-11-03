package io.github.harha.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.github.harha.rest.model.OPCUAServer;

@RestController
public class OPCUAServerController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/opcuaservers")
	public List<OPCUAServer> getServers() {
		List<OPCUAServer> results = new ArrayList<OPCUAServer>();
		results.add(new OPCUAServer(0, "localhost"));
		return results;
	}

}
