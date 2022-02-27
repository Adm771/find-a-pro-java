package com.group.findapro.communication.review.controller;

import com.group.findapro.communication.review.model.Review;
import com.group.findapro.communication.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@CrossOrigin
public class ReviewController {

    private ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) { this.reviewService = reviewService; }

    @GetMapping
    public List<Review> getAllReviews() { return reviewService.getAllReviews(); }
}
