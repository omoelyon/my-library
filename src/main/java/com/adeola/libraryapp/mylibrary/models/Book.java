package com.adeola.libraryapp.mylibrary.models;


import com.adeola.libraryapp.mylibrary.enums.BookStatus;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
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

}
