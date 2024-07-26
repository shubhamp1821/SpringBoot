package com.Technosignia.azon.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Technosignia.azon.Entity.Broker;

import com.Technosignia.azon.service.BrokerService;


@RestController
public class BrokerController {

	@Autowired  
	BrokerService brokerservice;
	
	@PostMapping("/broker")
	public Broker createBrokerDetails(@RequestBody Broker broker)
	{
		return brokerservice.createBrokerDeatails(broker);
	}
	
	@GetMapping("/broker")//this is called as a pathvariable
	public List<Broker> findAllBrokerDetails()
	{
		return  brokerservice.findAllBrokerDetails();	
	}
	
	@GetMapping("/broker/{id}")
	public Broker findBrokerDetails(@PathVariable Long id )
	{
		return brokerservice.findBrokerDetails(id);
	}
	
	@PutMapping("/broker")
		public Broker updateOwnerDetails(@RequestBody Broker broker,@RequestParam Long id)
		{
			return brokerservice.updateBrokerDetails(broker,id);
			
		}
	
	
	@DeleteMapping("/broker")
public Broker deleteBrokerDetails(@RequestParam Long id)
	
	{
		  Broker deletedBroker = brokerservice.deleteBrokerDetails(id);
		 return (deletedBroker);
		
	}
	
}
