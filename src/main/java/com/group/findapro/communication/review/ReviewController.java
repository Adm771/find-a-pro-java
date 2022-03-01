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

    @Autowired
    private ReviewService reviewService;


    // GET ALL REVIEW
    @GetMapping("review")
    public List<Review> getAllReview() {
        return this.reviewService.getAllReviews();
    }

    // GET REVIEW BY ID
    @GetMapping("/review/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable(value = "id") Long reviewId)
            throws ResourceNotFoundException {
        return reviewService.getReviewById(reviewId);
    }

    // ADD REVIEW
    @PostMapping("reviews")
    public Review createReview(@RequestBody Review review) {
        return this.reviewService.createReview(review);
    }

    // UPDATE REVIEW widziałem tutaj @Valid przed request body ale nie działa obecnie wcale ten @
    @PutMapping("/reviews/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable(value = "id") Long reviewId,
                                                 @RequestBody Review reviewDetails) throws ResourceNotFoundException {
        return reviewService.updateReview(reviewId,reviewDetails);
    }

    // DELETE REVIEW
    @DeleteMapping("/reviews/{id}")
    public Map<String, Boolean> deleteReview(@PathVariable(value = "id") Long reviewId)
            throws ResourceNotFoundException {
        return reviewService.deleteReview(reviewId);
    }

    // GET REVIEW FOR USER

    @GetMapping("/users/review/{userId}")
    public List<Review> getReviewForUser(@PathVariable(value = "userId") Long userId)
            throws ResourceNotFoundException {
        return reviewService.getReviewsForUser(userId);

    }


}