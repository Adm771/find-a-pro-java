package com.group.findapro.communication.review.controller;

import com.group.findapro.communication.review.service.ReviewService;
import com.group.findapro.communication.review.model.Review;
import com.group.findapro.exeptcions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin
public class ReviewController {

    public ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // GET ALL REVIEWS
    @GetMapping("reviews")
    public List<Review> getAllReviews() {
        return this.reviewService.getAllReviews();
    }

    // GET REVIEW BY ID
    @GetMapping("/reviews/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable(value = "id") Long reviewId)
            throws ResourceNotFoundException {
        Review review = reviewService.getReviewById(reviewId);
        return ResponseEntity.ok().body(review);
    }

    // ADD REVIEW
    @PostMapping("/reviews")
    public void createReview(@RequestBody Review newReview) {
        this.reviewService.addReview(newReview);
    }

    // UPDATE REVIEW
    @PutMapping("/reviews/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable(value = "id") Long reviewId,
                                                 @RequestBody Review review) throws ResourceNotFoundException {
        review = reviewService.updateReview(reviewId, review);

        return ResponseEntity.ok(review);
    }

    // DELETE REVIEW
    @DeleteMapping("/reviews/{id}")
    public ResponseEntity<Boolean>  deleteReview(@PathVariable(value = "id") Long reviewId)
            throws ResourceNotFoundException {

        reviewService.deleteReview(reviewId);
        return ResponseEntity.ok(true);
    }

    // GET REVIEW BY USER ID
    @GetMapping("/reviews/user/{userId}")
    public List<Review> getReviewsByUserId(@PathVariable(value = "userId") Long userId)
            throws ResourceNotFoundException{
        return reviewService.getReviewsByUserId(userId);
    }
}