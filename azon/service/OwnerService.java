package com.Technosignia.azon.service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Technosignia.azon.Entity.Owner;
import com.Technosignia.azon.Repository.OwnerRepository;

@Service
public class OwnerService {

	@Autowired
	OwnerRepository ownerRepository;
	
	public Owner createOwnerDeatails(Owner owner) {
		
		return ownerRepository.save(owner);
	}

	public Owner updateOwnerDetails(Owner owner, Long id) {
	Optional<Owner>opOwner=ownerRepository.findById(id);
	Owner dbOwner=null;
	if(opOwner.isPresent())
	{
	 dbOwner=opOwner.get();
				dbOwner.setName(owner.getName());
				dbOwner.setContact(owner.getContact());
				dbOwner.setEmail(owner.getEmail());
				dbOwner.setAddress(owner.getAddress());
				dbOwner.setProperties(owner.getProperties());
				ownerRepository.save(dbOwner);
	}
		return dbOwner;
	}


	public List<Owner> findAllOwnerDetails() {
	
		return ownerRepository.findAll();
	}

	public Owner deleteOwnerDetails( Long id) {
		 Owner dbOwner=null;
		  Optional<Owner> oppOwner = ownerRepository.findById(id);
	        if (oppOwner.isPresent()) {
	            dbOwner = oppOwner.get();
	            ownerRepository.delete(dbOwner);
	            
	        } 
	        return dbOwner;
	}

	public Owner findOwnerDetails(Long id) {
		 Owner dbOwner=null;
		Optional<Owner> opOwner=ownerRepository.findById(id);
		if(opOwner.isPresent())
		{
			dbOwner=opOwner.get();
			ownerRepository.save(dbOwner);
		}
		return dbOwner;
		
	}
}
