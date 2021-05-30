package com.example.jpa.Controller;

import com.example.jpa.Model.Tutorial;
import com.example.jpa.Repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/tutorial")
public class TutorialController {

    @Autowired
    TutorialRepository tutorialRepository;

    @GetMapping("/tutorials")
    public ResponseEntity<List<Tutorial>> gettAllTutorials(@RequestParam(required = false)String title) {
        try {
            List<Tutorial> tutorials = new ArrayList<Tutorial>();

            if (title == null)
                tutorialRepository.findAll().forEach(tutorials::add);
            else
                tutorialRepository.findBytitleContaining(title).forEach(tutorials::add);
            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        @GetMapping("/tutorial{id}")
        public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id) {
            Optional<Tutorial> tutorialData = tutorialRepository.findById(id);

            if (tutorialData.isPresent()) {
                return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }
        }

        @PostMapping("/tutorials")
        public ResponseEntity<Tutorial> createTutorial (@RequestBody Tutorial tutorial){
            try {
                Tutorial _tutorial = tutorialRepository
                        .save(new Tutorial(_tutorial.getTitle(), _tutorial.getDescription(), false));
                return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);

            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        @PutMapping("/tutorials/{id}")
        public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial)
        {
            Optional<Tutorial> tutorialData = tutorialRepository.findById(id);

            if (tutorialData.isPresent()) {
                Tutorial _tutorial = tutorialData.get();
                _tutorial.setTitle(tutorial.getTitle());
                _tutorial.setDescription(tutorial.getDescription());
                _tutorial.setPublished(tutorial.isPublished());
                return new ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }
        }
        @DeleteMapping("/tutorials")
        public ResponseEntity<HttpStatus> deleteAllTutorials () {
            try {
                tutorialRepository.deleteAll();
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
        @GetMapping("/tutorials/published")
        public ResponseEntity<List<Tutorial>> findByPublished() {
            try {
                List<Tutorial> tutorials = tutorialRepository.findByPublished(true);

                if (tutorials.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
                return new ResponseEntity<>(tutorials, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

            }
        }
    }

}
