package com.example.jpa.Repository;

import com.example.jpa.Model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.Model.Tutorial;

import java.util.List;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    List<Tutorial> findByPublished(boolean published);
    List<Tutorial> findBytitleContaining(String title);
}
