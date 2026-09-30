package com.auth_service_nov2.service;

import com.auth_service_nov2.dto.UserDto;
import com.auth_service_nov2.entity.User;
import com.auth_service_nov2.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDto addUser(UserDto userDto) {

        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User saved = userRepository.save(user);
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(saved, dto);

        return dto;
    }
}
