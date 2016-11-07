package io.github.harha.rest.api;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.github.harha.rest.model.OPCUAVariable;

public interface OPCUAVariableRepository extends MongoRepository<OPCUAVariable, String> {

	public List<OPCUAVariable> findByIdentifier(String identifier);
	public List<OPCUAVariable> findByNsIndex(Integer nsIndex);
	public List<OPCUAVariable> findByServerId(Integer serverId);
	public List<OPCUAVariable> findByIdentifierAndNsIndex(String identifier, Integer nsIndex);
	public List<OPCUAVariable> findByServerIdAndIdentifierAndNsIndex(Integer serverId, String identifier, Integer nsIndex);
	public List<OPCUAVariable> findByServerIdAndNsIndex(Integer serverId, Integer nsIndex);
	
}
