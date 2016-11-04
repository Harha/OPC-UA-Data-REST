package io.github.harha.rest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

public class OPCUAServer {
	
	@Id
	@Field("id")
	public String m_id;
	
	@Indexed(unique = true)
	@Field("serverId")
	public Integer m_serverId;
	
	@Field("endpoint")
	public String m_endpoint;
	
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

}
