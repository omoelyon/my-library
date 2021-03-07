package com.adeola.libraryapp.mylibrary.repository;

import com.adeola.libraryapp.mylibrary.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
