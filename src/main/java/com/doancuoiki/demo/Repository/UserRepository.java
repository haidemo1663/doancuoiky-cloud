package com.doancuoiki.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.doancuoiki.demo.Entity.User;

public interface UserRepository  extends MongoRepository<User,String>{

}
