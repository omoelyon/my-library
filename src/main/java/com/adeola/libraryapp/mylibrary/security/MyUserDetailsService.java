package com.adeola.libraryapp.mylibrary.security;

import com.adeola.libraryapp.mylibrary.models.MyUserDetails;
import com.adeola.libraryapp.mylibrary.models.User;
import com.adeola.libraryapp.mylibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user= userRepository.findByUsername(username);

        user.orElseThrow(()->new UsernameNotFoundException("Not found : "+ username));

        return  user.map(MyUserDetails::new).get();
    }
}