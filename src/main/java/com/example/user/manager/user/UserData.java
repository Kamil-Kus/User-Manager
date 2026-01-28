package com.example.user.manager.user;


import jakarta.persistence.*;
import lombok.*;

@Getter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserData {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nick")
    private String nick;
    @Column(name = "mail")
    private String mail;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Enumerated(EnumType.STRING)
    private Status status;
}
