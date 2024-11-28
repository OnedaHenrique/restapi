package com.restapi.restapi.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.restapi.UserDetailsService.JpaUserDetailsService;
import com.restapi.restapi.model.User;

@RestController
@RequestMapping("/createLogin")
public class AuthController {
    
    @Autowired
    private JpaUserDetailsService uService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        uService.postUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
