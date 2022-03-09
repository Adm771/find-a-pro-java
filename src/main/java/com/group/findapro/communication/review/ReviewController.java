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
@CrossOrigin(origins = "http://localhost:3000")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    public ReviewService reviewService;


    // GET ALL REVIEWS
    @GetMapping("reviews")
    public List<Review> getAllReviews() {
        return this.reviewRepository.findAll();
    }

    // GET REVIEW BY ID
    @GetMapping("/review/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable(value = "id") Long reviewId)
            throws ResourceNotFoundException {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found for this id :: " + reviewId));
        return ResponseEntity.ok().body(review);
    }

    // ADD REVIEW
    @PostMapping("reviews")
    public Review createReview(@RequestBody Review review) {
        return this.reviewRepository.save(review);
    }

    // UPDATE REVIEW widziałem tutaj @Valid przed request body ale nie działa obecnie wcale ten @
    @PutMapping("/reviews/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable(value = "id") Long reviewId,
                                                 @RequestBody Review reviewDetails) throws ResourceNotFoundException {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found for this id :: " + reviewId));

        review.setTitle(reviewDetails.getTitle());
        review.setDescription(reviewDetails.getDescription());
        review.setRating(reviewDetails.getRating());


        return ResponseEntity.ok(this.reviewRepository.save(review));
    }

    // DELETE REVIEW
    @DeleteMapping("/reviews/{id}")
    public Map<String, Boolean> deleteReview(@PathVariable(value = "id") Long reviewId)
            throws ResourceNotFoundException {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found for this id :: " + reviewId));

        reviewRepository.delete(review);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping("/reviews/{userId}")
    public List<Review> getReviewsByUserId(@PathVariable(value = "userId") Long userId)
            throws ResourceNotFoundException{
        return reviewService.getReviewsByUserId(userId);
    }
}