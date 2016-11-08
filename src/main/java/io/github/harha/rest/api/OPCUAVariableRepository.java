package io.github.harha.rest.api;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.github.harha.rest.model.OPCUAVariable;

public interface OPCUAVariableRepository extends MongoRepository<OPCUAVariable, String> {

	List<OPCUAVariable> findByIdentifierAndServerTimeStampGreaterThan(String identifier, Date serverTimeStamp);
	List<OPCUAVariable> findByNsIndexAndServerTimeStampGreaterThan(Integer nsIndex, Date serverTimeStamp);
	List<OPCUAVariable> findByServerIdAndServerTimeStampGreaterThan(Integer serverId, Date serverTimeStamp);
	
}
