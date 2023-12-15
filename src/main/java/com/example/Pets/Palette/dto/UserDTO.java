package com.example.Pets.Palette.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    @NotBlank
    String cognitoUsername;
    @NotBlank
    String chosenUsername;
}
