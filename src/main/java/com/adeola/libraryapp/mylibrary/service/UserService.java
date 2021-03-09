package com.adeola.libraryapp.mylibrary.service;

import com.adeola.libraryapp.mylibrary.exceptions.BookNotFoundException;
import com.adeola.libraryapp.mylibrary.models.AuthenticationRequest;
import com.adeola.libraryapp.mylibrary.models.Book;
import com.adeola.libraryapp.mylibrary.models.User;
import com.adeola.libraryapp.mylibrary.repository.BookRepository;
import com.adeola.libraryapp.mylibrary.repository.UserRepository;
import com.adeola.libraryapp.mylibrary.security.JwtUtil;
import com.adeola.libraryapp.mylibrary.security.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    BookRepository bookRepository;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtUtil;


    public  User save(User user) {
        return userRepository.save(user);
    }

    public String generateToken(AuthenticationRequest authenticationRequest) throws  Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername()
                            , authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e){
            throw new Exception("incorrect username or password"+ e);
        }
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        return jwt;
    }

    public Book lendBook(String title) {

        Optional<Book> book = Optional.ofNullable(bookRepository.findByTitle(title));
        book.orElseThrow(()->new BookNotFoundException("Not found : "+ title));
        return bookRepository.findByTitle(title);
    }
}
