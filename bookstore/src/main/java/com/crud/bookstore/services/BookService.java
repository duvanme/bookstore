package com.crud.bookstore.services;

import com.crud.bookstore.entities.Book;
import com.crud.bookstore.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookService {
   @Autowired
    private BookRepository bookRepository;

    public Book createBook(Book book){
        return  bookRepository.save(book);
    }
    public List<Book> getAllBooks(){
        return (List<Book>) bookRepository.findAll();
    }
    
    public Book findBookByID(Integer id){
        return bookRepository.findById(id).orElse(null);
    }

    public Book updateBook(Integer id, Book book){
        book.setId(id);
        return bookRepository.save(book);
    }

    public void deleteUser(Integer id){
        bookRepository.deleteById(id);
    };
}
