package com.Technosignia.azon.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Technosignia.azon.Entity.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property,Long> {

}
  