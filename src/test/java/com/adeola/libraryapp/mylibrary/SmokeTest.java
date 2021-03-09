package com.adeola.libraryapp.mylibrary;

import com.adeola.libraryapp.mylibrary.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmokeTest {
    @Autowired
    BookController bookController;


    @Test
    void contextLoads(){
        assertThat(bookController).isNotNull();
    }
}
