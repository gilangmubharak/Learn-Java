package com.example.java.guild.model.controller;

import com.example.java.guild.model.Model.Post;
import com.example.java.guild.model.Payload.PostDto;
import com.example.java.guild.model.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final ModelMapper modelMapper;
    private final PostService postService;

    public PostController(ModelMapper modelMapper, PostService postService) {
        super();
        this.modelMapper = modelMapper;
        this.postService = postService;
    }


    @GetMapping
    public List<PostDto> getAllpost() {
        return postService.getAllPosts().stream().map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());

    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") Long id) {
        Post post = postService.getPostById(id);

        //convert entity to DTO
        PostDto postResponse = modelMapper.map(post, PostDto.class);
        return ResponseEntity.ok().body(postResponse);

    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {

        //convert DTO to Entity
        Post postRequest = modelMapper.map(postDto, Post.class);
        Post post = postService.createpost(postRequest);

        //convert entity to DTO
        PostDto postResponse = modelMapper.map(post, PostDto.class);

        return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
    }

    //change the request for DTO
    //change the response for DTO
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable long id, @RequestBody PostDto postDto) {

        //convert DTO to Entity
        Post postRequest = modelMapper.map(postDto, Post.class);

        Post post = postService.updatePost(id, postRequest);

        //convert to DTO
        PostDto postResponse = modelMapper.map(post, PostDto.class);

        return ResponseEntity.ok().body(postResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable(name = "id") Long id) {
        postService.deletePost(id);
        return new ResponseEntity<>("Post deleted successfully", HttpStatus.OK);
    }


}