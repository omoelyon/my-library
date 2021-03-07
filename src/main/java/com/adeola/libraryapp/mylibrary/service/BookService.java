package com.adeola.libraryapp.mylibrary.service;

import com.adeola.libraryapp.mylibrary.enums.BookStatus;
import com.adeola.libraryapp.mylibrary.exceptions.BookNotFoundException;
import com.adeola.libraryapp.mylibrary.exceptions.InvalidBookEntryException;
import com.adeola.libraryapp.mylibrary.models.Book;
import com.adeola.libraryapp.mylibrary.repository.BookRepository;
import com.adeola.libraryapp.mylibrary.validations.BookValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookValidation bookValidation;

    public Book save(Book book) {
        if(bookValidation.isValidBook(book))
        return bookRepository.save(book);
        else
            throw new InvalidBookEntryException("book properties title, publisher and author must be present");
    }


    public Book update(Long bookId, Book book) {

        Optional<Book> myBook = bookRepository.findById(bookId);
        if(myBook.isPresent()) {
            Book newBook = myBook.get();
            newBook.setStatus(book.getStatus());
            newBook.setAuthor(book.getAuthor());
            newBook.setPublisher(book.getPublisher());
            newBook.setAuthor(book.getAuthor());
            newBook.setSubject(book.getSubject());
            return save(newBook);
        }
        else
            throw new BookNotFoundException("book not found");

    }
}
