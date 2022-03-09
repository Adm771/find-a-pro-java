package com.group.findapro.communication.review;

import com.group.findapro.communication.request.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    public List<Review> getReviewsByUserId(Long userId) {
        return reviewRepository.findAllByUserId(userId);
    }
}

