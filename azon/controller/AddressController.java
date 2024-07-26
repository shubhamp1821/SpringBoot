package com.Technosignia.azon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Technosignia.azon.Entity.Address;
import com.Technosignia.azon.service.AddressService;

@RestController
public class AddressController {

	@Autowired
	AddressService addressService;
	@PostMapping("/address")
	public Address createAddressDetails(@RequestBody Address add)
	{
		return addressService.createAddress(add);
	}
}
