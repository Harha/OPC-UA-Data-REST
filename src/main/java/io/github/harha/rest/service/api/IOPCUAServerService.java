package io.github.harha.rest.service.api;

import java.util.List;

import io.github.harha.rest.model.OPCUAServer;

public interface IOPCUAServerService {
	
	List<OPCUAServer> getServers(Integer serverId, String endpoint) throws Exception;
	void deleteServers(Integer serverId, String endpoint) throws Exception;
	void insertServer(OPCUAServer server) throws Exception;
	void updateServer(OPCUAServer server) throws Exception;

}
