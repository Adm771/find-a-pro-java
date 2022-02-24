package com.group.findapro.communication.review;

import lombok.*;

import javax.persistence.*;

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
    private java.sql.Date publishedOn;

    @Column(name = "star_count")
    private long starCount;

    // łączenie tabel


}
