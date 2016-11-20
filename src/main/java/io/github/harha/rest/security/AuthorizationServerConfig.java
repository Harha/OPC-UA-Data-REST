package io.github.harha.rest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	
	@Autowired
	private AuthenticationManager m_authManager;
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer config) throws Exception {
		config.authenticationManager(m_authManager);
	}
	
	@Override
	public void configure(ClientDetailsServiceConfigurer config) throws Exception {
		config.inMemory()
		.withClient("opc_ua_data_rest").secret("password")
		.authorizedGrantTypes("authorization_code", "refresh_token", "password");
	}
	
}