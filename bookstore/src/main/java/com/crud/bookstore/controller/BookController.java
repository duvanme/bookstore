package com.crud.bookstore.controller;

import com.crud.bookstore.entities.Book;
import com.crud.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;
    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book findBookById(@PathVariable("id") Integer id){
        return bookService.findBookByID(id);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book){
        return  bookService.createBook(book);
    }
}
