package com.adeola.libraryapp.mylibrary.repository;

import com.adeola.libraryapp.mylibrary.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book , Long> {
}
