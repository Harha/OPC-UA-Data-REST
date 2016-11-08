package io.github.harha.rest.api;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.github.harha.rest.model.OPCUASubscription;

public interface OPCUASubscriptionRepository extends MongoRepository<OPCUASubscription, String> {
	
	List<OPCUASubscription> findByIdentifier(String identifier);
	List<OPCUASubscription> findByNsIndex(Integer nsIndex);
	List<OPCUASubscription> findByServerId(Integer serverId);
	List<OPCUASubscription> findByNsIndexAndIdentifier(Integer nsIndex, String identifier);
	List<OPCUASubscription> findByServerIdAndNsIndex(Integer serverId, Integer nsIndex);
	List<OPCUASubscription> findByServerIdAndIdentifier(Integer serverId, String identifier);
	List<OPCUASubscription> findByServerIdAndNsIndexAndIdentifier(Integer serverId, Integer nsIndex, String identifier);

	void deleteByIdentifier(String identifier);
	void deleteByNsIndex(Integer nsIndex);
	void deleteByServerId(Integer serverId);
	void deleteByNsIndexAndIdentifier(Integer nsIndex, String identifier);
	void deleteByServerIdAndNsIndex(Integer serverId, Integer nsIndex);
	void deleteByServerIdAndIdentifier(Integer serverId, String identifier);
	void deleteByServerIdAndNsIndexAndIdentifier(Integer serverId, Integer nsIndex, String identifier);

}
