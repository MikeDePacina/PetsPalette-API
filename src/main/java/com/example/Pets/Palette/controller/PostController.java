package com.example.Pets.Palette.controller;

import com.example.Pets.Palette.dto.MessageDTO;
import com.example.Pets.Palette.dto.PostDTO;
import com.example.Pets.Palette.dto.PostList;
import com.example.Pets.Palette.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    private PostService postService;

    private QueueMessagingTemplate queueMessagingTemplate;

    @Value("${spring.cloud.aws.endpoint.uri}")
    private String endpoint;

    public PostController(PostService postService, QueueMessagingTemplate queueMessagingTemplate) {
        this.postService = postService;
        this.queueMessagingTemplate = queueMessagingTemplate;
    }

    @GetMapping
    public PostList getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> likePost(@PathVariable(name = "id") long id){
        return new ResponseEntity<String>(postService.likePost(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PostDTO> createPost(@Valid @RequestBody PostDTO postDTO){
        return new ResponseEntity<PostDTO>(postService.createPost(postDTO), HttpStatus.CREATED);
    }

    @GetMapping("/send/{id}")
    public void sendToQueue(@PathVariable(name = "id") String id){
        queueMessagingTemplate.send(endpoint, MessageBuilder.withPayload(id).build());
    }


}
