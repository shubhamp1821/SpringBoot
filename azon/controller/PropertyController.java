package com.Technosignia.azon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Technosignia.azon.Entity.Property;
import com.Technosignia.azon.service.PropertyService;

	@RestController//rest ful(web service) API Controller
	public class PropertyController {
	
	@Autowired//dependency injection  //object create//request for object  
	PropertyService  propertyService;//ioc controller
	
	
	@PostMapping("/property")//this full code is call we service
	public Property createPropertyDetails(@RequestBody Property prop)
	{
		return  propertyService.createPropertDetails(prop );
	}
	@GetMapping("/property")
	public List< Property> findAllPropertyDetails()
	{
		return propertyService.findAllPropertyDetails();	
	}
	@PutMapping("/property")
	public Property updatePropertyDetails(@RequestBody Property prop,@RequestParam Long id)
	{
		return propertyService.updatePropertyDetails(prop,id);
		}
	
	@GetMapping("/property/{id}")//this is called as a pathvariable
	public Property findPropertyDetailsById(@PathVariable Long id)
	{
		return propertyService.findPropertyDetailsById(id);	
	}
	}
