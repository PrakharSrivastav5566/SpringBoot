package com.example.todo_list.service;

import com.example.todo_list.dto.AuthResponseDto;
import com.example.todo_list.dto.LoginRequestDto;
import com.example.todo_list.dto.RegisterRequestDto;
import com.example.todo_list.model.UserModel;
import com.example.todo_list.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthService {
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public AuthResponseDto register(RegisterRequestDto request) {
        userRepository.findByEmail(request.email()).ifPresent(existing -> {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already registered");
        });

        UserModel user = new UserModel();
        user.setName(request.name());
        user.setEmail(request.email());
        user.setPassword(request.password());

        UserModel savedUser = userRepository.save(user);
        return new AuthResponseDto(savedUser.getId(), savedUser.getName(), savedUser.getEmail());
    }

    public AuthResponseDto login(LoginRequestDto request) {
        UserModel user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials"));

        if (!user.getPassword().equals(request.password())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
        }

        return new AuthResponseDto(user.getId(), user.getName(), user.getEmail());
    }
}
