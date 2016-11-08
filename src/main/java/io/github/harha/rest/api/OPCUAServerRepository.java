package io.github.harha.rest.api;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.github.harha.rest.model.OPCUAServer;

public interface OPCUAServerRepository extends MongoRepository<OPCUAServer, String> {
	
	List<OPCUAServer> findByServerId(Integer serverId);
	List<OPCUAServer> findByEndpoint(String endpoint);
	List<OPCUAServer> findByServerIdAndEndpoint(Integer serverId, String endpoint);
	void deleteByServerId(Integer serverId);
	void deleteByEndpoint(String endpoint);
	void deleteByServerIdAndEndpoint(Integer serverId, String endpoint);

}
