package com.example.Event.repository;

import com.example.Event.modal.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
