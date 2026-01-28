package com.example.user.manager.controller;

import com.example.user.manager.user.UserData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class ResponseMessageUsers {
    private String message;
    private List<UserData> userDataList;
}
