package io.github.harha.rest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="opc_ua_server")
public class OPCUAServer {
	
	@Id
	private String id;
	
	@Indexed(unique = true)
	@Field("serverId")
	private Integer serverId;
	
	@Field("endpoint")
	private String endpoint;
	
	@PersistenceConstructor
	public OPCUAServer(Integer serverId, String endpoint) {
		this.serverId = serverId;
		this.endpoint = endpoint;
	}
	
	public OPCUAServer() {
		serverId = null;
		endpoint = null;
	}
	
	@Override
	public String toString() {
		return String.format(
				"OPCUAServer[id=%s, serverId=%d, endpoint=%s]",
				id, serverId, endpoint
		);
	}
	
	public boolean containsNull() {
		return serverId == null || endpoint == null;
	}
	
	public String getId() {
		return id;
	}
	
	public Integer getServerId() {
		return serverId;
	}
	
	public String getEndpoint() {
		return endpoint;
	}
	
	public void setServerId(Integer serverId) {
		this.serverId = serverId;
	}
	
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

}
