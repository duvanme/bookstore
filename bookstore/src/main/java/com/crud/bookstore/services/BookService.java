package com.crud.bookstore.services;

import com.crud.bookstore.entities.Author;
import com.crud.bookstore.entities.Book;
import com.crud.bookstore.repositories.AuthorRepository;
import com.crud.bookstore.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookService {
   @Autowired
    private BookRepository bookRepository;

    @Autowired(required = false)
    private AuthorRepository authorRepository;

    public Book createBook(Book book){

        if (book.getAuthor() != null && book.getAuthor().getId() != null) {
            Integer authorId = book.getAuthor().getId();
            Author existingAuthor = authorRepository.findById(authorId).orElse(null);
            if (existingAuthor != null) {
                book.setAuthor(existingAuthor);
            }
        }

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
        Book bookToDelete = bookRepository.findById(id).orElse(null);
        bookToDelete.setAuthor(null);
        bookRepository.delete(bookToDelete);
    };
}
