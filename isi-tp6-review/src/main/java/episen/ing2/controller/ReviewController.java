package episen.ing2.controller;



import episen.ing2.persistence.Review;
import episen.ing2.persistence.ReviewRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;


import java.net.URI;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {

    static Logger logger = LogManager.getLogger(ReviewController.class);

    @Autowired
    protected ReviewRepository reviewRepository;

    @GetMapping(path = "/review/{id}")
    public ResponseEntity<Review> getReview(@PathVariable("id") Long reviewId) {
        Optional<Review> result = reviewRepository.findById(reviewId);
        if (result.isPresent()){
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
