package com.Technosignia.azon.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Technosignia.azon.Entity.Broker;





@Repository
public interface BrokerRepository extends JpaRepository<Broker,Long> {

}


