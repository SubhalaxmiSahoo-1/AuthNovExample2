package com.auth_service_nov2.controller;

import com.auth_service_nov2.dto.APIResponse;
import com.auth_service_nov2.dto.LoginDto;
import com.auth_service_nov2.dto.UserDto;
import com.auth_service_nov2.repository.UserRepository;
import com.auth_service_nov2.service.JwtService;
import com.auth_service_nov2.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class UserController {

    private UserService userService;
    private UserRepository userRepository;
    private AuthenticationManager authenticationManager;
    private JwtService jwtService;

    public UserController(UserService userService, UserRepository userRepository, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/doctor_signup")
    public ResponseEntity<APIResponse<String>> doctorSignUp(@RequestBody UserDto userDto){
        APIResponse<String> response = new APIResponse<>();
        if (userRepository.existsByEmail(userDto.getEmail())){
            response.setMessage("Error");
            response.setStatus(500);
            response.setData("Email already Exists");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (userRepository.existsByUsername(userDto.getUsername())){
            response.setMessage("Error");
            response.setStatus(500);
            response.setData("Username already exists");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        userDto.setRole("ROLE_DOCTOR");
        UserDto dto = userService.addUser(userDto);
        response.setMessage("Done");
        response.setStatus(201);
        response.setData("Registration Completed");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/patient_signup")
    public ResponseEntity<APIResponse<String>> patientSignUp(@RequestBody UserDto userDto){
        APIResponse<String> response = new APIResponse<>();
        if (userRepository.existsByEmail(userDto.getEmail())){
            response.setMessage("Error");
            response.setStatus(500);
            response.setData("Email already Exists");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (userRepository.existsByUsername(userDto.getUsername())){
            response.setMessage("Error");
            response.setStatus(500);
            response.setData("Username already exists");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        userDto.setRole("ROLE_PATIENT");
        UserDto dto = userService.addUser(userDto);
        response.setMessage("Done");
        response.setStatus(201);
        response.setData("Registration Completed");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<APIResponse<String>> signIn(@RequestBody LoginDto loginDto){

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());

        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        APIResponse<String> response = new APIResponse<>();
        if (authenticate.isAuthenticated()){
            String token = jwtService.generateToken(loginDto.getUsername(), "ADMIN");
            response.setMessage("Login Successful !!");
            response.setStatus(200);
            response.setData(token);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        response.setMessage("Failed");
        response.setStatus(401);
        response.setData("Un-Authorized Access");
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }
}
