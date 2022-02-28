package com.group.findapro.user.standard_user.model;

import com.group.findapro.communication.offer.model.Offer;
import com.group.findapro.communication.request.model.Request;
import com.group.findapro.communication.review.Review;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter

// TUTAJ JEST PRZYKLAD UNIKATOWYCH CONSTRAINTSOW W JPA PO STRONIE SERVERA
@Table(
        name = "users",
       uniqueConstraints = {
            @UniqueConstraint(name = "user_email_unique", columnNames = "email"),
               @UniqueConstraint(name = "user_phone_number_unique",columnNames = "phone_number")
        }
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number",
            unique = true)
    private long phoneNumber;

    @Column(name = "email",
            nullable = false)
    private String email;

    @Column(name = "password",
            nullable = false)
    private String password;

    @Column(name = "employment")
    private String employment;

    @Column(name = "profile_description")
    private String description;

    @OneToMany(targetEntity = Offer.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "uoffer_fk", referencedColumnName = "id")
    private List<Offer> offers;

    @OneToMany(targetEntity = Review.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "ureview_fk", referencedColumnName = "id")
    private List<Review> reviews;

    @OneToMany(targetEntity = Request.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "urequest_fk", referencedColumnName = "id")
    private List<Request> requests;
}