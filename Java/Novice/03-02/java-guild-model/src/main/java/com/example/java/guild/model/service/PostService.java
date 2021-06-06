package com.example.java.guild.model.service;

import com.example.java.guild.model.Model.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();

    Post createpost(Post post);

    Post updatePost(long id, Post post);

    Void deletePost(long id);

    Post getPostById(long id);

}
