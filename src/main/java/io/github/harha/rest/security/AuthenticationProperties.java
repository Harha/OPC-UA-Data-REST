package io.github.harha.rest.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "authentication")
public class AuthenticationProperties {
	
	private String adminUser;
	private String adminPass;
	private String readOnlyUser;
	private String readOnlyPass;
	
	public AuthenticationProperties() {
		adminUser = "opc_ua_data_rest_admin";
		adminPass = "password";
		readOnlyUser = "opc_ua_data_rest_readonly";
		readOnlyPass = "password";
	}
	
	public String getAdminUser() {
		return adminUser;
	}
	
	public String getAdminPass() {
		return adminPass;
	}
	
	public String getReadOnlyUser() {
		return readOnlyUser;
	}
	
	public String getReadOnlyPass() {
		return readOnlyPass;
	}
	
	public void setAdminUser(String adminUser) {
		this.adminUser = adminUser;
	}
	
	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}
	
	public void setReadOnlyUser(String readOnlyUser) {
		this.readOnlyUser = readOnlyUser;
	}
	
	public void setReadOnlyPass(String readOnlyPass) {
		this.readOnlyPass = readOnlyPass;
	}

}
