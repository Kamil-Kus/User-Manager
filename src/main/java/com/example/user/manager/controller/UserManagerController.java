package com.example.user.manager.controller;

import com.example.user.manager.user.UserData;
import com.example.user.manager.user.UserDTO;
import com.example.user.manager.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@Service
@AllArgsConstructor
@RestController(value = "/manager/user")
public class UserManagerController {

    private final UserRepository userRepository;

    @PostMapping(value = "/add")
    public ResponseEntity<ResponseMessage> addUser(@RequestBody UserDTO userDTO) {
        userRepository.addUser(userDTO);
        return new ResponseEntity<>(new ResponseMessage("Added new user"), HttpStatus.CREATED);
    }

    @GetMapping(value = "/list/all")
    public ResponseEntity<ResponseMessageUsers> getAllUsers() {
        var allUsers = userRepository.getAllUsers();
        return new ResponseEntity<>(new ResponseMessageUsers("All users.", allUsers), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseMessageUsers> getUserById(@PathVariable Long id) {
        Optional<UserData> userById = userRepository.getUserById(id);
        var users = userById
                .map(Arrays::asList)
                .orElse(new ArrayList<>());
        return new ResponseEntity<>(new ResponseMessageUsers("One user.", users), HttpStatus.OK);
    }

}
