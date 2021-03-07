package com.adeola.libraryapp.mylibrary.controller;

import com.adeola.libraryapp.mylibrary.enums.BookStatus;
import com.adeola.libraryapp.mylibrary.models.Book;
import com.adeola.libraryapp.mylibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add-book")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book newBook = new Book();
        newBook = book;
        book.setStatus(BookStatus.AVAILABLE);
        return new ResponseEntity<>(bookService.save(book), HttpStatus.CREATED);
    }

    @PutMapping("/update-book")
    public ResponseEntity<Book> updateBookDetails(@PathVariable Long bookId, @RequestBody Book book){

        return new ResponseEntity<>(bookService.update(bookId , book), HttpStatus.OK);
    }
}
