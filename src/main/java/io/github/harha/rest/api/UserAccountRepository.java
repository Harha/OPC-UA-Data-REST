package io.github.harha.rest.api;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.github.harha.rest.model.UserAccount;

public interface UserAccountRepository extends MongoRepository<UserAccount, String> {
	
	UserAccount findByUsername(String username);

}
