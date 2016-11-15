package io.github.harha.ioserver;

import java.util.logging.Logger;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;

public class SocketServer {
	
	private static final Logger LOGGER = Logger.getLogger(SocketServer.class.getName());
	
	private Configuration m_config;
	private SocketIOServer m_server;
	
	public SocketServer() {
		m_config = new Configuration();
		m_config.setHostname("0.0.0.0");
		m_config.setPort(9091);
		m_server = new SocketIOServer(m_config);
	}
	
	public void finalize() {
		
	}
	
	public void start() {
		
		Runnable task = () -> {
			LOGGER.info("SocketServer started, listening on: " + m_config.getHostname() + ":" + m_config.getPort());
			
			m_server.start();
		};
		
		Thread thread = new Thread(task);
		thread.start();
	}
	
	public void stop() {
		m_server.stop();
	}

}
