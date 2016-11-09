package io.github.harha.rest.api;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.mongodb.repository.MongoRepository;

import io.github.harha.rest.model.OPCUAVariable;

public interface OPCUAVariableRepository extends MongoRepository<OPCUAVariable, String> {

	List<OPCUAVariable> findByIdentifierAndServerTimeStampGreaterThan(String identifier, DateTime serverTimeStamp);
	List<OPCUAVariable> findByNsIndexAndServerTimeStampGreaterThan(Integer nsIndex, DateTime serverTimeStamp);
	List<OPCUAVariable> findByServerIdAndServerTimeStampGreaterThan(Integer serverId, DateTime serverTimeStamp);
	
}
