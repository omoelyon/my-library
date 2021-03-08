package com.adeola.libraryapp.mylibrary.controller;

import com.adeola.libraryapp.mylibrary.models.AuthenticationRequest;
import com.adeola.libraryapp.mylibrary.models.AuthenticationResponse;
import com.adeola.libraryapp.mylibrary.models.Book;
import com.adeola.libraryapp.mylibrary.models.User;
import com.adeola.libraryapp.mylibrary.security.JwtUtil;
import com.adeola.libraryapp.mylibrary.security.MyUserDetailsService;
import com.adeola.libraryapp.mylibrary.service.BookService;
import com.adeola.libraryapp.mylibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{

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
       return ResponseEntity.ok(new AuthenticationResponse(jwt));

    }

    @PostMapping("/lend-book/{title}")
    public ResponseEntity<Book> lendBook(@PathVariable String title){
        return ResponseEntity<>(userService.lendBook(title) ,HttpStatus.OK);

    }



}
