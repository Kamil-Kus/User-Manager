package com.example.user.manager.user;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserDTO {
    private String nick;
    private String mail;
    private Role role;
}
