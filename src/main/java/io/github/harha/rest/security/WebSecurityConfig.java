package io.github.harha.rest.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity config) throws Exception {
		config.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/opcuaservers/**").permitAll()
			.antMatchers(HttpMethod.GET, "/opcuasubscriptions/**").permitAll()
			.antMatchers(HttpMethod.GET, "/opcuavariables/**").permitAll()
			.antMatchers(HttpMethod.POST, "/**").hasAuthority("ADMIN")
			.antMatchers(HttpMethod.PUT, "/**").hasAuthority("ADMIN")
			.antMatchers(HttpMethod.DELETE, "/**").hasAuthority("ADMIN")
			.anyRequest().permitAll()
			.and()
			.httpBasic()
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.csrf().disable();
	}

}
