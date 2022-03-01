package com.group.findapro.communication.review;

import com.group.findapro.exeptcions.ResourceNotFoundException;
import com.group.findapro.user.standard_user.model.User;
import com.group.findapro.user.standard_user.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class ReviewService {

    private final UserRepository userRepository;

    private final ReviewRepository reviewRepository;

    public List<Review> getAllReviews(){
        return reviewRepository.findAll();
    }

    public ResponseEntity<Review>getReviewById(Long reviewId) throws ResourceNotFoundException {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found for this id :: " + reviewId));
        return ResponseEntity.ok().body(review);
    }

    public Review createReview(Review review){return reviewRepository.save(review);}

    public ResponseEntity<Review> updateReview(Long reviewId, Review reviewDetails) throws ResourceNotFoundException {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found for this id :: " + reviewId));

        review.setTitle(reviewDetails.getTitle());
        review.setDescription(reviewDetails.getDescription());
        review.setStarCount(reviewDetails.getStarCount());


        return ResponseEntity.ok(this.reviewRepository.save(review));
    }

    public Map<String, Boolean> deleteReview(Long reviewId) throws ResourceNotFoundException {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found for this id :: " + reviewId));

        reviewRepository.delete(review);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    public List<Review> getReviewsForUser(long userId) throws ResourceNotFoundException {
        User user =  userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found for this id :: " + userId));
        return user.getReviews();
    }


}
