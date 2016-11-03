package io.github.harha.rest.model;

public class OPCUAVariable {
	
	private int m_nsIndex;
	private String m_identifier;
	private int m_serverId;
	private String m_value;
	
	public OPCUAVariable(
			final int nsIndex,
			final String identifier,
			final int serverId,
			final String value
	) {
		m_nsIndex = nsIndex;
		m_identifier = identifier;
		m_serverId = serverId;
		m_value = value;
	}
	
	public int getNsIndex() {
		return m_nsIndex;
	}
	
	public String getIdentifier() {
		return m_identifier;
	}
	
	public int getServerId() {
		return m_serverId;
	}
	
	public String getValue() {
		return m_value;
	}

}
