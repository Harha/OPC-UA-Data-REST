package io.github.harha.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.harha.ioserver.SocketServer;

@SpringBootApplication
public class Main {
	
	public static void main(String[] args) {
		
		// Run REST
		SpringApplication.run(Main.class, args);
		
		// Run socket server
		SocketServer server = new SocketServer();
		server.start();
		
	}

}
