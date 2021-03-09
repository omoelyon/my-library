package com.adeola.libraryapp.mylibrary.utils;

import com.adeola.libraryapp.mylibrary.models.AuthenticationRequest;
import com.adeola.libraryapp.mylibrary.models.User;
import com.adeola.libraryapp.mylibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
//@Service
public class TestUtil {
    @Autowired
    AuthenticationRequest auth ;
    @Autowired
    UserService userService;
//    @Bean
    public String getToken() throws Exception{
        saveTestUser();
        auth = new AuthenticationRequest("test","test");
        String token = userService.generateToken(auth);
        return token;
    }

    private void saveTestUser(){
        User user = new User("foo","bar", "test","test");
        userService.save(user);
    }
}
