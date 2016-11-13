package io.github.harha.rest.service;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.harha.rest.api.OPCUAVariableRepository;
import io.github.harha.rest.model.OPCUAVariable;
import io.github.harha.rest.service.api.IOPCUAVariableService;

@Service
public class OPCUAVariableService implements IOPCUAVariableService {

	@Autowired
	private OPCUAVariableRepository m_repository;
	
	@Override
	public List<OPCUAVariable> getVariables(Integer nsIndex, String identifier, Integer serverId, DateTime serverTimeStampFrom, DateTime serverTimeStampTo) throws Exception {
		
		if (nsIndex != null && serverTimeStampFrom != null && serverTimeStampTo != null)
			return m_repository.findByNsIndexAndServerTimeStampBetween(nsIndex, serverTimeStampFrom, serverTimeStampTo);
	
		if (identifier != null && serverTimeStampFrom != null && serverTimeStampTo != null)
			return m_repository.findByIdentifierAndServerTimeStampBetween(identifier, serverTimeStampFrom, serverTimeStampTo);
		
		if (serverId != null && serverTimeStampFrom != null && serverTimeStampTo != null)
			return m_repository.findByServerIdAndServerTimeStampBetween(serverId, serverTimeStampFrom, serverTimeStampTo);
		
		throw new Exception("The request must contain a datetime parameter.");
	
	}

	@Override
	public void insertVariable(OPCUAVariable variable) throws Exception {
		
		if (variable.containsNull())
			throw new Exception("Input variable object is not allowed to contain NULL values.");
		
		m_repository.save(variable);
		
	}

}
