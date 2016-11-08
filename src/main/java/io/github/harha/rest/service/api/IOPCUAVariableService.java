package io.github.harha.rest.service.api;

import java.util.Date;
import java.util.List;

import io.github.harha.rest.model.OPCUAVariable;

public interface IOPCUAVariableService {
	
	List<OPCUAVariable> getVariables(Integer nsIndex, String identifier, Integer serverId, Date serverTimeStamp) throws Exception;
	void insertVariable(OPCUAVariable variable) throws Exception;

}
