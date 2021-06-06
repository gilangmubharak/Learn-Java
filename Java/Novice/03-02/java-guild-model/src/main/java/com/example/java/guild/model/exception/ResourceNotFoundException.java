package com.example.java.guild.model.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String post, String id, long id1) {
        super(post+id+id1);
    }
}
