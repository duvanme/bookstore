package com.crud.bookstore.repositories;

import com.crud.bookstore.entities.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Integer> {
}
