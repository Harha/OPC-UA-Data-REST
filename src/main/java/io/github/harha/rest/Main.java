package io.github.harha.rest;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import io.github.harha.rest.api.UserAccountRepository;
import io.github.harha.rest.model.UserAccount;
import io.github.harha.rest.security.AuthenticationProperties;

@Configuration
@ComponentScan(basePackages = {"io.github.harha.rest"})
@EnableAutoConfiguration
@SpringBootApplication
public class Main {
	
	// TODO: User account password encoding / decoding
	
	@Autowired
	private AuthenticationProperties m_authProperties;
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
	
    @Bean
    CommandLineRunner init(final UserAccountRepository repository) {
      
      return new CommandLineRunner() {

        @Override
        public void run(String... args) throws Exception {
        	repository.deleteAll();
        	repository.save(new UserAccount(m_authProperties.adminuser, m_authProperties.adminpass, new ArrayList<>(Arrays.asList("ADMIN", "USER"))));
        	repository.save(new UserAccount(m_authProperties.readonlyuser, m_authProperties.readonlypass, new ArrayList<>(Arrays.asList("USER"))));
        }
        
      };
      
    }

}
