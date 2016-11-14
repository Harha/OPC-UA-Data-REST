package io.github.harha.rest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="opc_ua_subscription")
public class OPCUASubscription {
	
	@Id
	public String id;
	
	@Indexed(unique = false)
	@Field("identifier")
	public String identifier;
	
	@Indexed(unique = false)
	@Field("nsIndex")
	public Integer nsIndex;
	
	@Indexed(unique = false)
	@Field("type")
	public String type;
	
	@Indexed(unique = false)
	@Field("serverId")
	public Integer serverId;
	
	@PersistenceConstructor
	public OPCUASubscription(
			String identifier,
			Integer nsIndex,
			String type,
			Integer serverId
	) {
		this.identifier = identifier;
		this.nsIndex = nsIndex;
		this.type = type;
		this.serverId = serverId;
	}
	
	public OPCUASubscription() {
		identifier = null;
		nsIndex = null;
		type = null;
		serverId = null;
	}
	
	@Override
	public String toString() {
		return String.format(
				"OPCUASubscription[id=%s, identifier=%s, nsIndex=%d, type=%s, serverId=%d]",
				id, identifier, nsIndex, type, serverId
		);
	}
	
	public boolean containsNull() {
		return identifier == null ||
			   nsIndex == null ||
			   type == null ||
			   serverId == null;
	}
	
	public String getId() {
		return id;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public Integer getNsIndex() {
		return nsIndex;
	}
	
	public String getType() {
		return type;
	}
	
	public Integer getServerId() {
		return serverId;
	}
	
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
	public  void setNsIndex(Integer nsIndex) {
		this.nsIndex = nsIndex;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setServerId(Integer serverId) {
		this.serverId = serverId;
	}

}
