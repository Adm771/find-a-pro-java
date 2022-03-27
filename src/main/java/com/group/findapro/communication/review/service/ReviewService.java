package com.group.findapro.communication.review.service;

import com.group.findapro.communication.review.model.Review;
import com.group.findapro.communication.review.repository.ReviewRepository;
import com.group.findapro.exeptcions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ReviewService {

    ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAllReviews() { return reviewRepository.findAll(); }

    public Review getReviewById(Long reviewId) throws ResourceNotFoundException {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found for this id :: " + reviewId));
        return review;
    }

    public void addReview(Review newReview) {
        reviewRepository.save(newReview);
    }

    @Transactional
    public Review updateReview(long reviewId, Review review) throws ResourceNotFoundException {
        System.out.println("Fetching review with id = " + reviewId);
        Review reviewEdited = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found for this id :: " + reviewId));
        System.out.println("Updating of " + reviewEdited);

        reviewEdited.setDescription(review.getDescription());
        reviewEdited.setRating(review.getRating());

        System.out.println("Updated to " + reviewEdited);
        // unnecessary because of "dirty checking"
        reviewRepository.save(reviewEdited);
        return reviewEdited;
    }

    public List<Review> getReviewsByUserId(Long userId) { return reviewRepository.findAllByUserId(userId); }

    public boolean deleteReview(Long reviewId) throws ResourceNotFoundException {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found for this id :: " + reviewId));
        reviewRepository.deleteById(reviewId);
        return true;
    }
}

