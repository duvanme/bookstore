package com.crud.bookstore.repositories;

import com.crud.bookstore.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Integer> {

}
