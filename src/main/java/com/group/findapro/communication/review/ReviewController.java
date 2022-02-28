package com.group.findapro.communication.review;

import com.group.findapro.exeptcions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;


    // GET ALL REVIEW
    @GetMapping("review")
    public List<Review> getAllOffers() {
        return this.reviewRepository.findAll();
    }

    // GET REVIEW BY ID
    @GetMapping("/review/{id}")
    public ResponseEntity<Review> getEmployeeById(@PathVariable(value = "id") Long reviewId)
            throws ResourceNotFoundException {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Offer not found for this id :: " + reviewId));
        return ResponseEntity.ok().body(review);
    }

    // ADD REVIEW
    @PostMapping("reviews")
    public Review createUser(@RequestBody Review review) {
        return this.reviewRepository.save(review);
    }

    // UPDATE REVIEW widziałem tutaj @Valid przed request body ale nie działa obecnie wcale ten @
    @PutMapping("/reviews/{id}")
    public ResponseEntity<Review> updateEmployee(@PathVariable(value = "id") Long reviewId,
                                                 @RequestBody Review userDetails) throws ResourceNotFoundException {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + reviewId));

        review.setTitle(userDetails.getTitle());
        review.setDescription(userDetails.getDescription());
        review.setStarCount(userDetails.getStarCount());


        return ResponseEntity.ok(this.reviewRepository.save(review));
    }

    // DELETE REVIEW
    @DeleteMapping("/reviews/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long reviewId)
            throws ResourceNotFoundException {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + reviewId));

        reviewRepository.delete(review);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}