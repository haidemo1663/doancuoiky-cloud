package com.doancuoiki.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.doancuoiki.demo.Entity.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,String>{

}
