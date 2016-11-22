package io.github.harha.rest.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="opc_ua_user_account")
public class UserAccount {
	
	@Id
	private String id;
	
	@Indexed(unique = true)
	@Field("username")
	private String username;
	
	@Field("password")
	private String password;
	
	@Field("roles")
	private List<String> roles;
	
	@PersistenceConstructor
	public UserAccount(String username, String password, List<String> roles) {
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	
	public UserAccount() {
		username = null;
		password = null;
		roles = null;
	}
	
	@Override
	public String toString() {
		return String.format(
				"UserAccount[id=%s, username=%s]",
				id, username
		);
	}
	
	public boolean containsNull() {
		return username == null || password == null;
	}
	
	public String getId() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public List<String> getRoles() {
		return roles;
	}
	
	public void setUsername(String username)  {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

}
