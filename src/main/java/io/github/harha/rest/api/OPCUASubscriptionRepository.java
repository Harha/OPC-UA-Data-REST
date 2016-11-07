package io.github.harha.rest.api;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.github.harha.rest.model.OPCUASubscription;

public interface OPCUASubscriptionRepository extends MongoRepository<OPCUASubscription, String> {
	
	public List<OPCUASubscription> findByIdentifier(String identifier);
	public List<OPCUASubscription> findByNsIndex(Integer nsIndex);
	public List<OPCUASubscription> findByServerId(Integer serverId);
	public List<OPCUASubscription> findByServerIdAndIdentifier(Integer serverId, String identifier);

}
