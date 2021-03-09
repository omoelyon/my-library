package com.adeola.libraryapp.mylibrary.models;


import com.adeola.libraryapp.mylibrary.enums.BookStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String title;
    private String author;
    private String publisher;
    private String subject;
    private BookStatus status;



    public Book(String title, String author, String publisher, String subject) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.subject = subject;
    }
}
