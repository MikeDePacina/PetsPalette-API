package com.example.Pets.Palette.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class PostDTO {
    private long id;
    @NotBlank
    @Size(min=1, max=500)
    private String body;

    @NotBlank
    private String username;

    @NotBlank
    private String cognitoUsername;

    private long numberOfLikes = 0;

}
