package com.Technosignia.azon.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Technosignia.azon.Entity.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner,Long> {

}
