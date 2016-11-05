package io.github.harha.rest.api;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.github.harha.rest.model.OPCUAServer;

public interface OPCUAServerRepository extends MongoRepository<OPCUAServer, String> {
	
	public OPCUAServer findByServerId(Integer serverId);
	public List<OPCUAServer> findByEndpoint(String endpoint);
	public void deleteByServerId(Integer serverId);
	public void deleteByEndpoint(String endpoint);

}
