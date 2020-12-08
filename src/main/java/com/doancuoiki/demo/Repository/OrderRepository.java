package com.doancuoiki.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.doancuoiki.demo.Entity.Order;
@Repository
public interface OrderRepository extends MongoRepository<Order, String>{
		
}
