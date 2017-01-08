package io.github.harha.rest;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import io.github.harha.rest.api.UserAccountRepository;
import io.github.harha.rest.model.UserAccount;
import io.github.harha.rest.security.AuthenticationConfig;
import io.github.harha.rest.security.AuthenticationProperties;

@Configuration
@ComponentScan(basePackages = { "io.github.harha.rest" })
@PropertySource("application.properties")
@EnableAutoConfiguration
@EnableConfigurationProperties
@SpringBootApplication
public class Main {

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
				repository.save(new UserAccount(m_authProperties.getAdminUser(),
						AuthenticationConfig.BCRYPT.encode(m_authProperties.getAdminPass()),
						new ArrayList<>(Arrays.asList("ADMIN", "USER"))));
				repository.save(new UserAccount(m_authProperties.getReadOnlyUser(),
						AuthenticationConfig.BCRYPT.encode(m_authProperties.getReadOnlyPass()),
						new ArrayList<>(Arrays.asList("USER"))));
			}

		};

	}

}
