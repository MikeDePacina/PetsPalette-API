package com.example.Pets.Palette.service;

import com.example.Pets.Palette.dto.PostDTO;
import com.example.Pets.Palette.dto.PostList;
import com.example.Pets.Palette.model.Post;
import com.example.Pets.Palette.model.User;
import com.example.Pets.Palette.repository.PostRepository;
import com.example.Pets.Palette.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {
    private PostRepository postRepository;
    private UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public String likePost(long id){
        Post post = postRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Resource not found"));
        post.setNumOfLikes(post.getNumOfLikes() + 1);
        postRepository.save(post);
        return "liked";
    }
    public PostList getAllPosts() {
        List<PostDTO> posts = postRepository.findAll().stream().map(post -> convertToDTO(post)).collect(Collectors.toList());
        PostList pl = new PostList();
        pl.setPosts(posts);
        return pl;
    }

    public PostDTO createPost(PostDTO postDTO){
        Post post = new Post();
        post.setBody(postDTO.getBody());
        post.setNumOfLikes(0);
        User owner = userRepository.findByCognitoUsername(postDTO.getCognitoUsername());
        post.setUploader(owner);
        Post savedPost = postRepository.save(post);
        PostDTO res = convertToDTO(savedPost);
        return res;
    }
    public PostDTO getPost(long id) {
        Post post = postRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Resource not found"));
        PostDTO res = convertToDTO(post);
        return res;
    }

    private PostDTO convertToDTO(Post post){
        PostDTO res = new PostDTO();
        res.setId(post.getId());
        res.setCognitoUsername(post.getUploader().getCognitoUsername());
        res.setUsername(post.getUploader().getUserName());
        res.setBody(post.getBody());
        res.setNumberOfLikes(post.getNumOfLikes());
        return res;
    }

}
