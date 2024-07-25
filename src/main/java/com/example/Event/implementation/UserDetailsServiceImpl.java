package com.example.Event.implementation;


import com.example.Event.enums.role;
import com.example.Event.modal.User;
import com.example.Event.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =userRepository.findByUsername(username);
        System.out.println(user.getUsername()+"////"+user.getPassword());
        return user.builder().username(user.getUsername()).password(user.getPassword()).role(user.getRole()).build();

    }


}
