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
	
	@Field("identifier")
	private String identifier;
	
	@PersistenceConstructor
	public OPCUAServer(Integer serverId, String endpoint, String identifier) {
		this.serverId = serverId;
		this.endpoint = endpoint;
		this.identifier = identifier;
	}
	
	public OPCUAServer() {
		serverId = null;
		endpoint = null;
		identifier = null;
	}
	
	@Override
	public String toString() {
		return String.format(
				"OPCUAServer[id=%s, serverId=%d, endpoint=%s, identifier=%s]",
				id, serverId, endpoint, identifier
		);
	}
	
	public boolean containsNull() {
		return serverId == null || endpoint == null || identifier == null;
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
	
	public String getIdentifier() {
		return identifier;
	}
	
	public void setServerId(Integer serverId) {
		this.serverId = serverId;
	}
	
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

}
