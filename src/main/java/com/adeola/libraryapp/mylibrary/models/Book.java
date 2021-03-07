package com.adeola.libraryapp.mylibrary.models;


import com.adeola.libraryapp.mylibrary.enums.BookStatus;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

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
