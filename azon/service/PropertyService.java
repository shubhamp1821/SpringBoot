package com.Technosignia.azon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Technosignia.azon.Entity.Property;
import com.Technosignia.azon.Repository.PropertyRepository;

@Service
public class PropertyService {
	
	@Autowired// called dependency injection because propertycontroller on propertyservice
	PropertyRepository propertyRepository;
public Property createPropertDetails(Property prop)
{
	return 	propertyRepository.save(prop) ;
}
public List<Property> findAllPropertyDetails() {
	
	return propertyRepository.findAll();
}
public Property updatePropertyDetails(Property prop, Long id) {
	
	Optional<Property> OptionalProp=propertyRepository.findById( id);
	Property property=null;
	if(OptionalProp.isPresent())//if object is present or not 
	{
		 property=OptionalProp.get();
		property.setAddress(prop.getAddress());
		propertyRepository.save(property);
	}
	return property ;
}
public Property findPropertyDetailsById(Long id) {

return propertyRepository.findById(id).get();

}
}
