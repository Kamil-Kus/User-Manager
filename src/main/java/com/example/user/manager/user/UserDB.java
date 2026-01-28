package com.example.user.manager.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDB extends JpaRepository<UserData, Long> {
}
