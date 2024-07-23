package com.example.Event.repository;

import com.example.Event.modal.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {
}
