package io.github.harha.rest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="opc_ua_server")
public class OPCUAServer {
	
	@Id
	private String m_id;
	
	@Indexed(unique = true)
	@Field("serverId")
	private Integer m_serverId;
	
	@Field("endpoint")
	private String m_endpoint;
	
	@PersistenceConstructor
	public OPCUAServer(Integer serverId, String endpoint) {
		m_serverId = serverId;
		m_endpoint = endpoint;
	}
	
	public OPCUAServer() {
		m_serverId = null;
		m_endpoint = null;
	}
	
	@Override
	public String toString() {
		return String.format(
				"OPCUAServer[id=%s, serverId=%d, endpoint=%s]",
				m_id, m_serverId, m_endpoint
		);
	}
	
	public String getId() {
		return m_id;
	}
	
	public Integer getServerId() {
		return m_serverId;
	}
	
	public String getEndpoint() {
		return m_endpoint;
	}
	
	public void setServerId(Integer serverId) {
		m_serverId = serverId;
	}
	
	public void setEndpoint(String endpoint) {
		m_endpoint = endpoint;
	}

}
