package io.github.harha.rest.model;

import java.time.LocalDate;

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
	@Field("nsIndex")
	public Integer nsIndex;
	
	@Indexed(unique = false)
	@Field("identifier")
	public String identifier;
	
	@Indexed(unique = false)
	@Field("serverId")
	public Integer serverId;
	
	@Field("value")
	public String value;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Field("serverTimeStamp")
	public LocalDate serverTimeStamp;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Field("localTimeStamp")
	public LocalDate localTimeStamp;
	
	@PersistenceConstructor
	public OPCUAVariable(
			Integer nsIndex,
			String identifier,
			Integer serverId,
			String value
	) {
		this.nsIndex = nsIndex;
		this.identifier = identifier;
		this.serverId = serverId;
		this.value = value;
	}
	
	public OPCUAVariable() {
		nsIndex = null;
		identifier = null;
		serverId = null;
		value = null;
	}
	
	@Override
	public String toString() {
		return String.format(
				"OPCUAVariable[id=%s, nsIndex=%d, identifier=%s, serverId=%d, value=%s, serverTimeStamp=%s, localTimeStamp=%s]",
				id, nsIndex, identifier, serverId, value, serverTimeStamp, localTimeStamp
		);
	}
	
	public boolean containsNull() {
		return nsIndex == null ||
			   identifier == null ||
			   serverId == null ||
			   value == null;
	}
	
	public String getId() {
		return id;
	}
	
	public Integer getNsIndex() {
		return nsIndex;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public Integer getServerId() {
		return serverId;
	}
	
	public String getValue() {
		return value;
	}
	
	public LocalDate getServerTimeStamp() {
		return serverTimeStamp;
	}
	
	public LocalDate getLocalTimeStamp() {
		return localTimeStamp;
	}
	
	public  void setNsIndex(Integer nsIndex) {
		this.nsIndex = nsIndex;
	}
	
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
	public void setServerId(Integer serverId) {
		this.serverId = serverId;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public void setServerTimeStamp(LocalDate serverTimeStamp) {
		this.serverTimeStamp = serverTimeStamp;
	}
	
	public void setLocalTimeStamp(LocalDate localTimeStamp) {
		this.localTimeStamp = localTimeStamp;
	}

}
