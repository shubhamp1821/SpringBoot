package com.Technosignia.azon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Technosignia.azon.Entity.Broker;

import com.Technosignia.azon.Repository.BrokerRepository;

@Service
public class BrokerService {

	@Autowired
	BrokerRepository brokerRepository;
	
	//create
	public Broker createBrokerDeatails(Broker broker) {
		
		return brokerRepository.save(broker);
	}

	//update
     public Broker updateBrokerDetails(Broker broker, Long id) {
		Optional<Broker> opBroker=brokerRepository.findById(id);
		Broker dbBroker=null;
		if(opBroker.isPresent())
		{
			dbBroker=opBroker.get();
			dbBroker.setName(broker.getName());
			dbBroker.setContact(broker.getContact());
			dbBroker.setEmail(broker.getEmail());
			dbBroker.setAddress(broker.getAddress());
			dbBroker.setProperties(broker.getProperties());
			brokerRepository.save(dbBroker);
		}
		return dbBroker;
	}

	//get
	public List<Broker> findAllBrokerDetails() {
		
		return brokerRepository.findAll();
	}
	
	//getbyid
	public Broker findBrokerDetails(Long id) {
		 Broker dbbroker=null;
			Optional<Broker> opbroker=brokerRepository.findById(id);
			if(opbroker.isPresent())
			{
				dbbroker=opbroker.get();
				brokerRepository.save(dbbroker);
			}
			return dbbroker;
	}

	//delete
	public Broker deleteBrokerDetails(Long id) {
		 Broker dbBroker=null;
		  Optional<Broker> oppBroker = brokerRepository.findById(id);
	        if (oppBroker.isPresent()) {
	            dbBroker = oppBroker.get();
	            brokerRepository.delete(dbBroker);
	            
	        } 
	        return dbBroker;
	}

	
}