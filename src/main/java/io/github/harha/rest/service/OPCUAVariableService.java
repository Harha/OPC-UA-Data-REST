package io.github.harha.rest.service;

import java.util.Date;
import java.util.List;

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
	public List<OPCUAVariable> getVariables(Integer nsIndex, String identifier, Integer serverId, Date serverTimeStamp) throws Exception {
		
		if (nsIndex != null && serverTimeStamp != null)
			return m_repository.findByNsIndexAndServerTimeStampGreaterThan(nsIndex, serverTimeStamp);
	
		if (identifier != null && serverTimeStamp != null)
			return m_repository.findByIdentifierAndServerTimeStampGreaterThan(identifier, serverTimeStamp);
		
		if (serverId != null && serverTimeStamp != null)
			return m_repository.findByServerIdAndServerTimeStampGreaterThan(serverId, serverTimeStamp);
		
		throw new Exception("The request must contain a datetime parameter.");
	
	}

	@Override
	public void insertVariable(OPCUAVariable variable) throws Exception {
		
		if (variable.containsNull())
			throw new Exception("Input variable object is not allowed to contain NULL values.");
		
		m_repository.save(variable);
		
	}

}
