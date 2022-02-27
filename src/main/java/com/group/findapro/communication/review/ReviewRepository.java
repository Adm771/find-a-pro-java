package com.group.findapro.communication.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("select r from Review r where r.reviewId = ?1 and r.user = ?2")
    List<Review> findByReviewIdAndUser();
}
