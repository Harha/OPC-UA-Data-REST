package io.github.harha.rest.api;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.mongodb.repository.MongoRepository;

import io.github.harha.rest.model.OPCUAVariable;

public interface OPCUAVariableRepository extends MongoRepository<OPCUAVariable, String> {

	List<OPCUAVariable> findByIdentifierAndServerTimeStampBetween(String identifier, DateTime from, DateTime to);
	List<OPCUAVariable> findByNsIndexAndServerTimeStampBetween(Integer nsIndex, DateTime from, DateTime to);
	List<OPCUAVariable> findByServerIdAndServerTimeStampBetween(Integer serverId, DateTime from, DateTime to);
	
}
