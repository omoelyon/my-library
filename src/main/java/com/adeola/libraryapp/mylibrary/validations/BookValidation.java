package com.adeola.libraryapp.mylibrary.validations;

import com.adeola.libraryapp.mylibrary.models.Book;
import org.springframework.stereotype.Component;

@Component
public class BookValidation {
    public boolean isValidBook(Book book){
        return book.getTitle() != null && !book.getTitle().equals("") && book.getPublisher() !=null && book.getAuthor() != null && !book.getAuthor().equals("") && !book.getPublisher().equals("");
    }
}
