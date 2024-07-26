package com.Technosignia.azon.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Technosignia.azon.Entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
