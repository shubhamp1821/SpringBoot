package com.Technosignia.azon.Entity;
import java.util.List;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Owner 
{
@Id//primary key
//@GeneratedValue(strategy=GenerationType.AUTO)
Long id;
String name;
String email;
Long contact;

@OneToOne//one owner has one address
Address address;

@OneToMany//one owner can have many properties
List<Property>properties;

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

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public Long getContact() {
	return contact;
}

public void setContact(Long contact) {
	this.contact = contact;
}

public Address getAddress() {
	return address;
}

public void setAddress(Address address) {
	this.address = address;
}

public List<Property> getProperties() {
	return properties;
}

public void setProperties(List<Property> properties) {
	this.properties = properties;
}
	
	

}
