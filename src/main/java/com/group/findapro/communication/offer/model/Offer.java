package com.group.findapro.communication.offer.model;

import com.group.findapro.user.standard_user.model.User;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "Offers")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long offerId;

    @Column(name = "offer_title")
    private String title;

    @Column(name = "payment")
    private double payment;

    @Column(name = "offer_description")
    private String description;

    @Column(name = "published_on")
    private LocalDateTime publishedOn;

    @Column(name = "archived")
    private boolean archived;

//    @OneToOne
//    @JoinColumn(
//            name = "user_id",
//            referencedColumnName = "userId"
//    )
//    private User user;

    // added
    @ElementCollection
    public List<Integer> serviceCategoryId;

    // temporary
    private long handymanId;

    private String postCode;

    public Offer(String title, double payment, String description, LocalDateTime publishedOn, boolean archived, List<Integer> serviceCategoryId, long handymanId, String postCode) {
        this.title = title;
        this.payment = payment;
        this.description = description;
        this.publishedOn = publishedOn;
        this.archived = archived;
        this.serviceCategoryId = serviceCategoryId;
        this.handymanId = handymanId;
        this.postCode = postCode;
    }
}
