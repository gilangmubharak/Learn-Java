package com.example.java.guild.model.postrepository;

import com.example.java.guild.model.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
