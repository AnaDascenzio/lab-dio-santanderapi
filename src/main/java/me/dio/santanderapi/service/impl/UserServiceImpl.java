package me.dio.santanderapi.service.impl;

import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.santanderapi.domain.dto.UserDto;
import me.dio.santanderapi.domain.model.User;
import me.dio.santanderapi.domain.repository.UserRepository;
import me.dio.santanderapi.service.UserService;
import me.dio.santanderapi.service.converter.Converter;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private Converter converter;

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDto findById(Long id) {
        return converter.toDto(userRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }

    @Override
    public UserDto create(User user) {
        if(userRepository.existsByAccountNumber(user.getAccount().getNumber())){
            throw new IllegalArgumentException("This Account Number already exists");
        }
        return converter.toDto(userRepository.save(user));
    }
    
}
