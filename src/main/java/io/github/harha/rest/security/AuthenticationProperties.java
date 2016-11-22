package io.github.harha.rest.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("app.authproperties")
public class AuthenticationProperties {
	
	public String adminuser = "opc_ua_data_rest_admin";
	public String adminpass = "password";
	public String readonlyuser = "opc_ua_data_rest_readonly";
	public String readonlypass = "password";

}
