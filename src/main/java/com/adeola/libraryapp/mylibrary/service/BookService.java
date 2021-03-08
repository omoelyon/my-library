package com.adeola.libraryapp.mylibrary.service;

import com.adeola.libraryapp.mylibrary.exceptions.BookNotFoundException;
import com.adeola.libraryapp.mylibrary.exceptions.InvalidBookEntryException;
import com.adeola.libraryapp.mylibrary.models.Book;
import com.adeola.libraryapp.mylibrary.repository.BookRepository;
import com.adeola.libraryapp.mylibrary.validations.BookValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookValidation bookValidation;
    @Autowired
    BookSearch bookSearch;

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

    public void deleteById(long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> search(String t){
        List<Book> result = new ArrayList<>();
        List<List<Book>> searchResult = bookSearch.search(t);

        for (List<Book> l: searchResult)
            result.addAll(l);

        return result;
    }


}
