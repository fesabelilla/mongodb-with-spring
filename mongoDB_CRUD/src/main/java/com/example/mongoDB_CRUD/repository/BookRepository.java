package com.example.mongoDB_CRUD.repository;

import com.example.mongoDB_CRUD.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, Integer> {
}
