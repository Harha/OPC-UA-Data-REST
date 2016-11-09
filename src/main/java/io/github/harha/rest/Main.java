package io.github.harha.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class Main extends WebMvcConfigurerAdapter {
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

}
