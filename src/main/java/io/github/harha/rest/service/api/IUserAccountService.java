package io.github.harha.rest.service.api;

import io.github.harha.rest.model.UserAccount;

public interface IUserAccountService {
	
	UserAccount getUserAccount(String username) throws Exception;

}
