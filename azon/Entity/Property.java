package com.Technosignia.azon.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity 
public class Property {
	
@Id
Long id;

String name;

Double sellPrice;

Double rentPrice;

Long propertyAge;

String configuration;//1bhkk 2bhk;

String furnishingStatus;//furnish 

String propertyType;//comersial residential

@OneToOne
Address address;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Double getSellPrice() {
	return sellPrice;
}

public void setSellPrice(Double sellPrice) {
	this.sellPrice = sellPrice;
}

public Double getRentPrice() {
	return rentPrice;
}

public void setRentPrice(Double rentPrice) {
	this.rentPrice = rentPrice;
}

public Long getPropertyAge() {
	return propertyAge;
}

public void setPropertyAge(Long propertyAge) {
	this.propertyAge = propertyAge;
}

public String getConfiguration() {
	return configuration;
}

public void setConfiguration(String configuration) {
	this.configuration = configuration;
}

public String getFurnishingStatus() {
	return furnishingStatus;
}

public void setFurnishingStatus(String furnishingStatus) {
	this.furnishingStatus = furnishingStatus;
}

public String getPropertyType() {
	return propertyType;
}

public void setPropertyType(String propertyType) {
	this.propertyType = propertyType;
}

public Address getAddress() {
	return address;
}

public void setAddress(Address address) {
	this.address = address;
}

}
