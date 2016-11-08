package io.github.harha.rest.model;

import java.util.Date;

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
	@Field("serverId")
	public Integer serverId;
	
	@Field("value")
	public String value;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Field("serverTimeStamp")
	public Date serverTimeStamp;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Field("localTimeStamp")
	public Date localTimeStamp;
	
	@PersistenceConstructor
	public OPCUAVariable(
			String identifier,
			Integer nsIndex,
			Integer serverId,
			String value,
			Date serverTimeStamp
	) {
		this.identifier = identifier;
		this.nsIndex = nsIndex;
		this.serverId = serverId;
		this.value = value;
		this.serverTimeStamp = serverTimeStamp;
		this.localTimeStamp = new Date();
	}
	
	public OPCUAVariable() {
		identifier = null;
		nsIndex = null;
		serverId = null;
		value = null;
		serverTimeStamp = null;
		localTimeStamp = new Date();
	}
	
	@Override
	public String toString() {
		return String.format(
				"OPCUAVariable[id=%s, identifier=%s, nsIndex=%d, serverId=%d, value=%s, serverTimeStamp=%s, localTimeStamp=%s]",
				id, identifier, nsIndex, serverId, value, serverTimeStamp, localTimeStamp
		);
	}
	
	public boolean containsNull() {
		return identifier == null ||
			   nsIndex == null ||
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
	
	public Integer getServerId() {
		return serverId;
	}
	
	public String getValue() {
		return value;
	}
	
	public Date getServerTimeStamp() {
		return serverTimeStamp;
	}
	
	public Date getLocalTimeStamp() {
		return localTimeStamp;
	}
	
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
	public  void setNsIndex(Integer nsIndex) {
		this.nsIndex = nsIndex;
	}
	
	public void setServerId(Integer serverId) {
		this.serverId = serverId;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public void setServerTimeStamp(Date serverTimeStamp) {
		this.serverTimeStamp = serverTimeStamp;
	}
	
	public void setLocalTimeStamp(Date localTimeStamp) {
		this.localTimeStamp = localTimeStamp;
	}

}
