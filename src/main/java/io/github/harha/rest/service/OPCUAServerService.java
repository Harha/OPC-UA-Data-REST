package io.github.harha.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.harha.rest.api.OPCUAServerRepository;
import io.github.harha.rest.model.OPCUAServer;
import io.github.harha.rest.service.api.IOPCUAServerService;

@Service
public class OPCUAServerService implements IOPCUAServerService {
	
	@Autowired
	private OPCUAServerRepository m_repository;

	@Override
	public List<OPCUAServer> getServers(Integer serverId, String endpoint) throws Exception {
		
		if (serverId == null && endpoint == null) {
			return m_repository.findAll();
		} else if (serverId != null && endpoint == null) {
			return m_repository.findByServerId(serverId);
		} else if (serverId == null && endpoint != null) {
			return m_repository.findByEndpoint(endpoint);
		}
		
		return m_repository.findByServerIdAndEndpoint(serverId, endpoint);
	}

	@Override
	public void deleteServers(Integer serverId, String endpoint) throws Exception {
		
		if (serverId == null && endpoint == null) {
			m_repository.deleteAll();
		} else if (serverId != null && endpoint == null) {
			m_repository.deleteByServerId(serverId);
		} else if (serverId == null && endpoint != null) {
			m_repository.deleteByEndpoint(endpoint);
		}
		
		m_repository.deleteByServerIdAndEndpoint(serverId, endpoint);
		
	}

	@Override
	public void insertServer(OPCUAServer server) throws Exception {
		
		if (server.containsNull())
			throw new Exception("Input server object is not allowed to contain NULL values.");
		
		m_repository.save(server);
		
	}

	@Override
	public void updateServer(OPCUAServer server) throws Exception {
		
		if (server.containsNull())
			throw new Exception("Input server object is not allowed to contain NULL values.");
		
		OPCUAServer server_db = null;
		
		if ((server_db = m_repository.findByServerId(server.getServerId()).get(0)) == null)
			throw new Exception("Cannot find a server from the database with given serverId.");
		
		server_db.setEndpoint(server.getEndpoint());
		m_repository.save(server_db);
		
	}

}
