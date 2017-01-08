package io.github.harha.rest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import io.github.harha.rest.api.UserAccountRepository;
import io.github.harha.rest.model.UserAccount;

@Configuration
public class AuthenticationConfig extends GlobalAuthenticationConfigurerAdapter {

	public static BCryptPasswordEncoder BCRYPT = new BCryptPasswordEncoder();

	@Autowired
	private UserAccountRepository m_repository;

	@Override
	public void init(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(getUserDetailsService());
	}

	@Bean
	public UserDetailsService getUserDetailsService() {
		return new UserDetailsService() {

			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				UserAccount account = m_repository.findByUsername(username);

				if (account == null)
					throw new UsernameNotFoundException("Could not find the user '" + username + "'.");

				return new User(account.getUsername(), account.getPassword(), true, true, true, true,
						AuthorityUtils.createAuthorityList(account.getRoles().toArray(new String[0])));
			}

		};
	}

}
