package com.example.Pets.Palette.controller;

import com.example.Pets.Palette.dto.UserDTO;
import com.example.Pets.Palette.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{cognitoUsername}")
    public UserDTO checkUser(@PathVariable(name = "cognitoUsername") String cognitoUsername ){
        return userService.newUser(cognitoUsername);
    }
    @PostMapping
    public ResponseEntity<String> createUser(@Valid @RequestBody UserDTO userDTO){
        return new ResponseEntity<String>(userService.createUser(userDTO), HttpStatus.CREATED);
    }

}
