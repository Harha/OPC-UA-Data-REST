package io.github.harha.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.harha.rest.api.UserAccountRepository;
import io.github.harha.rest.model.UserAccount;
import io.github.harha.rest.service.api.IUserAccountService;

@Service
public class UserAccountService implements IUserAccountService {
	
	@Autowired
	private UserAccountRepository m_repository;

	@Override
	public UserAccount getUserAccount(String username) throws Exception {
		return m_repository.findByUsername(username);
	}

}
