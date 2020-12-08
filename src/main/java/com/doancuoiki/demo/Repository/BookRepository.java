package com.doancuoiki.demo.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.doancuoiki.demo.Entity.Book;
@Repository
public interface BookRepository extends MongoRepository<Book,String>{
	public Optional<Book> findById(String id);
}
