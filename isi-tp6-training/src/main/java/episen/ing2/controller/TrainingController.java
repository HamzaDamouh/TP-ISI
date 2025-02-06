package episen.ing2.controller;


import episen.ing2.persistence.Training;
import episen.ing2.persistence.TrainingRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TrainingController {

    static Logger logger = LogManager.getLogger(TrainingController.class);

    @Autowired
    protected TrainingRepository trainingRepository;

    @GetMapping(path = "/review/{id}")
    public ResponseEntity<Training> getReview(@PathVariable("id") Long reviewId) {
        Optional<Training> result = trainingRepository.findById(reviewId);
        if (result.isPresent()){
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
