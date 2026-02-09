package com.example.productivity_app.controller;

import com.example.productivity_app.dto.UserCreateDto;
import com.example.productivity_app.dto.UserCreateResponseDto;
import com.example.productivity_app.entity.User;
import com.example.productivity_app.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserCreateResponseDto> createUser(@RequestBody UserCreateDto dto) {
        User user = userService.createUser(dto);

        UserCreateResponseDto response = new UserCreateResponseDto(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}