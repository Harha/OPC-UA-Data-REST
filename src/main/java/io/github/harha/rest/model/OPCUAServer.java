package io.github.harha.rest.model;

public class OPCUAServer {
	
	private int m_id;
	private String m_endpoint;
	
	public OPCUAServer(
			final int id,
			final String endpoint
	) {
		m_id = id;
		m_endpoint = endpoint;
	}
	
	public int getId() {
		return m_id;
	}
	
	public String getEndpoint() {
		return m_endpoint;
	}

}
