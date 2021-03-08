package com.adeola.libraryapp.mylibrary.repository;

import com.adeola.libraryapp.mylibrary.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book , Long> {
    List<Book> findByTitleContains(String title);
    List<Book> findBySubjectContains(String subject);
    List<Book> findByPublisherContains(String publisher);
    List<Book> findByAuthorContains(String author);
    Book findByTitle(String title);
}
