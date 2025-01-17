package com.example.Event.repository;

import com.example.Event.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;



public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
    //List<User> findDistinctByRole_User();
    @Query(nativeQuery = true , value = "Select * from user where user.role ='USER'")
    List<User> findAllUsers();

}
