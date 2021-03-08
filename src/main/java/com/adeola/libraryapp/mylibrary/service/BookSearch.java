package com.adeola.libraryapp.mylibrary.service;

import com.adeola.libraryapp.mylibrary.interfaces.Search;
import com.adeola.libraryapp.mylibrary.models.Book;
import com.adeola.libraryapp.mylibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BookSearch implements Search<String,List<Book>> {
    @Autowired
    BookRepository bookRepository;

    public List<List<Book>> search(String o) {
        List books = new ArrayList<Book>();
        books.add(bookRepository.findByAuthorContains(o));
        books.add(bookRepository.findByPublisherContains(o));
        books.add(bookRepository.findBySubjectContains(o));
        books.add(bookRepository.findByTitleContains(o));
        return books;
    }
}
