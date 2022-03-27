package com.group.findapro.user.standard_user.model;

import com.group.findapro.communication.offer.model.Offer;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
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

    @Column(name = "phone_number")
    private long phoneNumber;

    @Column(name = "email",
            nullable = false)
    private String email;

    @Column(name = "password",
            nullable = false)
    private String password;

    @Column(name = "profile_description")
    private String description;

    @OneToOne
    @JoinColumn(name = "offer_id", referencedColumnName = "offerId")
    private Offer offer;

    // Which one better in this case?
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinTable(name = "user_offer",
//            joinColumns =
//                    { @JoinColumn(name = "user_id", referencedColumnName = "userId", updatable = false, insertable = false) },
//            inverseJoinColumns =
//                    { @JoinColumn(name = "offer_id", referencedColumnName = "offerId", updatable = false, insertable = false) })
//    private Offer offer;

    public User(String firstName, String lastName, long phoneNumber, String email, String password, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.description = description;
    }
}

//
////    2022-02-28 18:54:30.682 ERROR 29348 --- [           main] j.LocalContainerEntityManagerFactoryBean : Failed to initialize JPA EntityManagerFactory: Unable to map collection com.group.findapro.user.standard_user.model.User.reviews
//    @OneToMany(targetEntity = Review.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "ureview_fk", referencedColumnName = "id")
//    private List<Review> reviews;
//
//    @OneToMany(targetEntity = Request.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "urequest_fk", referencedColumnName = "id")
//    private List<Request> requests;