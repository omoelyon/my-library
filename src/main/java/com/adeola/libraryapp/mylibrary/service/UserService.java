package com.adeola.libraryapp.mylibrary.service;

import com.adeola.libraryapp.mylibrary.exceptions.BookNotFoundException;
import com.adeola.libraryapp.mylibrary.models.Book;
import com.adeola.libraryapp.mylibrary.models.User;
import com.adeola.libraryapp.mylibrary.repository.BookRepository;
import com.adeola.libraryapp.mylibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    BookRepository bookRepository;


    public  User save(User user) {
        return userRepository.save(user);
    }

    public Book lendBook(String title) {

        Optional<Book> book = Optional.ofNullable(bookRepository.findByTitle(title));
        book.orElseThrow(()->new BookNotFoundException("Not found : "+ title));
        return bookRepository.findByTitle(title);
    }
}
