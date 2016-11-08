package io.github.harha.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.harha.rest.api.OPCUASubscriptionRepository;
import io.github.harha.rest.model.OPCUASubscription;
import io.github.harha.rest.service.api.IOPCUASubscriptionService;

@Service
public class OPCUASubscriptionService implements IOPCUASubscriptionService {
	
	@Autowired
	private OPCUASubscriptionRepository m_repository;

	@Override
	public List<OPCUASubscription> getSubscriptions(Integer nsIndex, String identifier, Integer serverId) throws Exception {
		
		if (nsIndex == null && identifier == null && serverId == null) {
			return m_repository.findAll();
		} else if (nsIndex != null && identifier == null && serverId == null) {
			return m_repository.findByNsIndex(nsIndex); 
		} else if (nsIndex == null && identifier != null && serverId == null) {
			return m_repository.findByIdentifier(identifier);
		} else if (nsIndex == null && identifier == null && serverId != null) {
			return m_repository.findByServerId(serverId);
		} else if (nsIndex != null && identifier != null && serverId == null) {
			return m_repository.findByNsIndexAndIdentifier(nsIndex, identifier);
		} else if (nsIndex != null && identifier == null && serverId != null) {
			return m_repository.findByServerIdAndNsIndex(serverId, nsIndex);
		} else if (nsIndex == null && identifier != null && serverId != null) {
			return m_repository.findByServerIdAndIdentifier(serverId, identifier);
		}
		
		return m_repository.findByServerIdAndNsIndexAndIdentifier(serverId, nsIndex, identifier);
		
	}

	@Override
	public void deleteSubscriptions(Integer nsIndex, String identifier, Integer serverId) throws Exception {
		
		if (nsIndex == null && identifier == null && serverId == null) {
			m_repository.deleteAll();
		} else if (nsIndex != null && identifier == null && serverId == null) {
			m_repository.deleteByNsIndex(nsIndex); 
		} else if (nsIndex == null && identifier != null && serverId == null) {
			m_repository.deleteByIdentifier(identifier);
		} else if (nsIndex == null && identifier == null && serverId != null) {
			m_repository.deleteByServerId(serverId);
		} else if (nsIndex != null && identifier != null && serverId == null) {
			m_repository.deleteByNsIndexAndIdentifier(nsIndex, identifier);
		} else if (nsIndex != null && identifier == null && serverId != null) {
			m_repository.deleteByServerIdAndNsIndex(serverId, nsIndex);
		} else if (nsIndex == null && identifier != null && serverId != null) {
			m_repository.deleteByServerIdAndIdentifier(serverId, identifier);
		}
		
		m_repository.deleteByServerIdAndNsIndexAndIdentifier(serverId, nsIndex, identifier);
		
	}

	@Override
	public void insertSubscription(OPCUASubscription subscription) throws Exception {
		
		if (subscription.containsNull())
			throw new Exception("Input subscription object is not allowed to contain NULL values.");
		
		m_repository.save(subscription);
		
	}

}
