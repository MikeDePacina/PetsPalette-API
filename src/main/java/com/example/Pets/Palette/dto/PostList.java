package com.example.Pets.Palette.dto;

import com.example.Pets.Palette.model.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class PostList {
    private List<PostDTO> posts;
}
