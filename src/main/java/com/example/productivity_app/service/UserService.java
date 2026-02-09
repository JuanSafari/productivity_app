package com.example.productivity_app.service;

import com.example.productivity_app.dto.UserCreateDto;
import com.example.productivity_app.entity.User;
import com.example.productivity_app.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserCreateDto dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setLevel(1);
        user.setCurrentXP(0);
        user.setTotalXP(0);
        return userRepository.save(user);
    }
}
