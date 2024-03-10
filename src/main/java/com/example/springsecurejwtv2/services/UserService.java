package com.example.springsecurejwtv2.services;

import com.example.springsecurejwtv2.exception.UserNameAlreadyExistsException;
import com.example.springsecurejwtv2.model.RegisterRequest;
import com.example.springsecurejwtv2.model.UserEntity;
import com.example.springsecurejwtv2.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createNewUser(RegisterRequest registerRequest) throws UserNameAlreadyExistsException {
        Optional<UserEntity> result = userRepository.findById(registerRequest.getUserName());
        result.ifPresentOrElse(
                (u) -> {
                    throw new UserNameAlreadyExistsException(
                            String.format("User Name [%s] Already Exists", u.getName())
                    );
                },
                () -> {
                    userRepository.save(UserEntity.builder()
                            .name(registerRequest.getUserName())
                            .password(registerRequest.getPassword())
                            .email(registerRequest.getEmail())
                            .build());
                }
        );
    }

}