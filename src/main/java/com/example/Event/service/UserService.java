package com.example.Event.service;

import com.example.Event.modal.User;
import com.example.Event.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;


    @Transactional
    public void signUp(User signupRequest) {

        String hashedPassword = passwordEncoder.encode(signupRequest.getPassword());
        signupRequest.setPassword(hashedPassword);
        signupRequest.setUsername((signupRequest.getUsername()));

        userRepository.save(signupRequest);
    }
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }
    public String deleteUser (Integer Iduser){
        userRepository.deleteById(Iduser);
        return "User est Supprimer avec succes !";
    }

}
