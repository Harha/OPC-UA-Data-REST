package io.github.harha.rest.model;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Document(collection="opc_ua_variable")
public class OPCUAVariable {
	
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
	
	@Field("value")
	public String value;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Indexed(unique = true)
	@Field("serverTimeStamp")
	public DateTime serverTimeStamp;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Indexed(unique = false)
	@Field("localTimeStamp")
	public DateTime localTimeStamp;
	
	@PersistenceConstructor
	public OPCUAVariable(
			String identifier,
			Integer nsIndex,
			String type,
			Integer serverId,
			String value,
			DateTime serverTimeStamp
	) {
		this.identifier = identifier;
		this.nsIndex = nsIndex;
		this.type = type;
		this.serverId = serverId;
		this.value = value;
		this.serverTimeStamp = serverTimeStamp;
		this.localTimeStamp = new DateTime();
	}
	
	public OPCUAVariable() {
		identifier = null;
		nsIndex = null;
		type = null;
		serverId = null;
		value = null;
		serverTimeStamp = null;
		localTimeStamp = new DateTime();
	}
	
	@Override
	public String toString() {
		return String.format(
				"OPCUAVariable[id=%s, identifier=%s, nsIndex=%d, type=%s, serverId=%d, value=%s, serverTimeStamp=%s, localTimeStamp=%s]",
				id, identifier, nsIndex, type, serverId, value, serverTimeStamp, localTimeStamp
		);
	}
	
	public boolean containsNull() {
		return identifier == null ||
			   nsIndex == null ||
			   type == null ||
			   serverId == null ||
			   value == null ||
			   serverTimeStamp == null ||
			   localTimeStamp == null;
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
	
	public String getValue() {
		return value;
	}
	
	public DateTime getServerTimeStamp() {
		return serverTimeStamp;
	}
	
	public DateTime getLocalTimeStamp() {
		return localTimeStamp;
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
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public void setServerTimeStamp(@DateTimeFormat(iso = ISO.DATE_TIME) DateTime serverTimeStamp) {
		this.serverTimeStamp = serverTimeStamp;
	}
	
	public void setLocalTimeStamp(@DateTimeFormat(iso = ISO.DATE_TIME) DateTime localTimeStamp) {
		this.localTimeStamp = localTimeStamp;
	}

}
