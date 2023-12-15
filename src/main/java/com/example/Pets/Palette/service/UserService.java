package com.example.Pets.Palette.service;

import com.example.Pets.Palette.dto.UserDTO;
import com.example.Pets.Palette.model.User;
import com.example.Pets.Palette.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO newUser(String cognitoUsername){
        User user;
        UserDTO res;
        if(userRepository.existsByCognitoUsername(cognitoUsername)){
           user = userRepository.findByCognitoUsername(cognitoUsername);
           res = new UserDTO();
           res.setChosenUsername(user.getUserName());
           res.setCognitoUsername(user.getCognitoUsername());
           return res;
        }
        return null;
    }

    public String createUser(UserDTO userDTO){
        User newUser = new User();
        newUser.setCognitoUsername(userDTO.getCognitoUsername());
        newUser.setUserName(userDTO.getChosenUsername());
        return userRepository.save(newUser).getUserName();
    }

    public String getUsername(String cognitoUsername){
        User user = userRepository.findByCognitoUsername(cognitoUsername);
        return user.getUserName();
    }
}
