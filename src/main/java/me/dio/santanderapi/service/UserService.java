package me.dio.santanderapi.service;

import me.dio.santanderapi.domain.dto.UserDto;
import me.dio.santanderapi.domain.model.User;

public interface UserService {

    UserDto findById(Long id);

    UserDto create(User user);
    
}
