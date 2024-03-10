package com.example.springsecurejwtv2.repository;

import com.example.springsecurejwtv2.model.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, String> {
}
