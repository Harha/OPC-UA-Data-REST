package io.github.harha.rest.service.api;

import java.util.List;

import org.joda.time.DateTime;

import io.github.harha.rest.model.OPCUAVariable;

public interface IOPCUAVariableService {
	
	List<OPCUAVariable> getVariables(Integer nsIndex, String identifier, Integer serverId, DateTime serverTimeStamp) throws Exception;
	void insertVariable(OPCUAVariable variable) throws Exception;

}
