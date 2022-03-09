package com.group.findapro.communication.review;

import com.group.findapro.user.standard_user.model.User;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reviewId;

    @Column(name = "review_title")
    private String title;

    @Column(name = "review_description")
    private String description;

    @Column(name = "published_on")
    private LocalDate publishedOn;

    //rating better?
    @Column(name = "rating")
    private long rating;

    //added
    @Column(name = "user_id",
            updatable = false)
    private Long userId;

    @Column(name = "handyman_id"
    )
    private Long handymanId;

    public Review(String title, String description, LocalDate publishedOn, long rating, Long userId, Long handymanId) {
        this.title = title;
        this.description = description;
        this.publishedOn = publishedOn;
        this.rating = rating;
        this.userId = userId;
        this.handymanId = handymanId;
    }
}
