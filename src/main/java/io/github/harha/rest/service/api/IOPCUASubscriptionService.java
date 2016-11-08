package io.github.harha.rest.service.api;

import java.util.List;

import io.github.harha.rest.model.OPCUASubscription;

public interface IOPCUASubscriptionService {
	
	List<OPCUASubscription> getSubscriptions(Integer nsIndex, String identifier, Integer serverId) throws Exception;
	void deleteSubscriptions(Integer nsIndex, String identifier, Integer serverId) throws Exception;
	void insertSubscription(OPCUASubscription subscription) throws Exception;

}
