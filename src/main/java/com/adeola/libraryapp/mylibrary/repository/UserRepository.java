package com.adeola.libraryapp.mylibrary.repository;

import com.adeola.libraryapp.mylibrary.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
