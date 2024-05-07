package com.crud.bookstore.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="book")
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private String title;
    private String isbn;
    @Column(name = "date_of_publication")
    private LocalDate dateOfPub;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")

    private Author author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getDateOfPub() {
        return dateOfPub;
    }

    public void setDateOfPub(LocalDate dateOfPub) {
        this.dateOfPub = dateOfPub;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
