package com.example.productivity_app.dto;

import com.example.productivity_app.entity.User;
import lombok.Data;

@Data
public class UserCreateResponseDto {
    private Long id;

    private String username;

    public UserCreateResponseDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
    }
}
