package com.crud.bookstore.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="book")
@NoArgsConstructor
@AllArgsConstructor
@Data
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

    public void setAuthor(Author author) {
        this.author = author;
    }
}
