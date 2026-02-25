package com.example.user.manager.user;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
public class UserRepository {
    private UserDB userDB;

    public void addUser(UserDTO userDTO) {
        var newUser = UserData.builder()
                .nick(userDTO.getNick())
                .mail(userDTO.getMail())
                .role(userDTO.getRole())
                .status(Status.ACTIVE)
                .build();
        userDB.save(newUser);
        log.info("Added user {}", newUser);
    }

    public void deleteUser(Long id) {
        userDB.deleteById(id);
    }

    public Optional<UserData> getUserById(Long id) {
        return userDB.findById(id);
    }

    public List<UserData> getAllUsers() {
        return userDB.findAll();
    }
}
