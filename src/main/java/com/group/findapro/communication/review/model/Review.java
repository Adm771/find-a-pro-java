package com.group.findapro.communication.review.model;

import com.group.findapro.user.standard_user.model.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @Column(name = "review_description",
            columnDefinition = "VARCHAR(800)")
    private String description;

    @Column(name = "published_on")
    private LocalDateTime publishedOn;

    @Column(name = "rating")
    private int rating;

    // received by user:
    @Column(name = "user_id")
    private Long userId;

    // written by user:
    @Column(name = "written_by"
    )
    private Long writtenBy;

    public Review(String description, LocalDateTime publishedOn, int rating, Long userId, Long writtenBy) {
        this.description = description;
        this.publishedOn = publishedOn;
        this.rating = rating;
        this.userId = userId;
        this.writtenBy = writtenBy;
    }
}
