package com.example.Event.Controller;

import com.example.Event.modal.User;
import com.example.Event.repository.UserRepository;
import com.example.Event.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("admin/ListUsers")
    public List<User> ListUsers() {
        return userService.findAllUsers();
    }
}




