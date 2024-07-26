package com.Technosignia.azon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Technosignia.azon.Entity.Address;
import com.Technosignia.azon.Repository.AddressRepository;



@Service
public class AddressService {

	@Autowired
	  AddressRepository addressRepository;
	
	@Transactional
	public Address createAddress(Address add) {
		return addressRepository.save(add);
	}
}
