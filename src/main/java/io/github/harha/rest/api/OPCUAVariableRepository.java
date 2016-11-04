package io.github.harha.rest.api;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.github.harha.rest.model.OPCUAVariable;

public interface OPCUAVariableRepository extends MongoRepository<OPCUAVariable, String> {

	public List<OPCUAVariable> findByNsIndex(Integer nsIndex);
	public List<OPCUAVariable> findByIdentifier(String identifier);
	public List<OPCUAVariable> findByServerId(String serverId);
	
}
