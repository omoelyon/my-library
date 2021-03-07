package com.adeola.libraryapp.mylibrary.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping("/getarray")
    public int[] testUserController(){
        int[] myArray = {1,2,3,4,5,6,7,8};
        return myArray;
    }

}
