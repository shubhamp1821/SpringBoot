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

import com.Technosignia.azon.Entity.Owner;

import com.Technosignia.azon.service.OwnerService;

@RestController

public class OwnerController {

	@Autowired  
	OwnerService ownerservice;
	
	@PostMapping("/owner")
	public Owner createOwnerDetails(@RequestBody Owner owner)
	{
		return  ownerservice.createOwnerDeatails(owner);
	}
	@PutMapping("/owner")
		public Owner updateOwnerDetails(@RequestBody Owner owner,@RequestParam Long id)
		{
			return ownerservice.updateOwnerDetails(owner,id);
			
		}
	@GetMapping("/owner")//this is called as a pathvariable
	public List<Owner> findAllOwnerDetails()
	{
		return ownerservice.findAllOwnerDetails();	
	}
	
	@GetMapping("/owner/{id}")
	public Owner findOwnerDetails(@PathVariable Long id )
	{
		return ownerservice.findOwnerDetails(id);
	}

	@DeleteMapping("/owner")
	public Owner deleteOwnerDetails(@RequestParam Long id)
	
	{
		  Owner deletedOwner = ownerservice.deleteOwnerDetails(id);
		 return (deletedOwner);
		
	}

}