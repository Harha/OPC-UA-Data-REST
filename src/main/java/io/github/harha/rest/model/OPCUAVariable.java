package io.github.harha.rest.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class OPCUAVariable {
	
	@Id
	@Field("id")
	public String m_id;
	
	@Field("nsIndex")
	public Integer m_nsIndex;
	
	@Field("identifier")
	public String m_identifier;
	
	@Field("serverId")
	public Integer m_serverId;
	
	@Field("value")
	public String m_value;
	
	@DateTimeFormat(iso = ISO.DATE)
	public LocalDate m_timeStamp;
	
	@Override
	public String toString() {
		return String.format(
				"OPCUAVariable[id=%s, nsIndex=%d, identifier=%s, serverId=%d, value=%s, timeStamp=%s]",
				m_id, m_nsIndex, m_identifier, m_serverId, m_value, m_timeStamp
		);
	}
	
	public String getId() {
		return m_id;
	}
	
	public Integer getNsIndex() {
		return m_nsIndex;
	}
	
	public String getIdentifier() {
		return m_identifier;
	}
	
	public Integer getServerId() {
		return m_serverId;
	}
	
	public String getValue() {
		return m_value;
	}
	
	public LocalDate getTimeStamp() {
		return m_timeStamp;
	}

}
