package com.group.findapro.communication.offer.model;

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
@Table(name = "offers")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long offerId;

    @Column(name = "offer_title",
            columnDefinition = "VARCHAR(100)")
    private String title;

    @Column(name = "payment")
    private double payment;

    @Column(name = "offer_description")
    private String description;

    @Column(name = "published_on")
    private LocalDateTime publishedOn;

    @Column(name = "archived")
    private boolean archived;

    private int serviceCategoryId;

    private String postCode;

    @OneToOne(mappedBy = "offer")
    private User user;

    public Offer(String title, double payment, String description, LocalDateTime publishedOn, int serviceCategoryId, String postCode) {
        this.title = title;
        this.payment = payment;
        this.description = description;
        this.publishedOn = publishedOn;
        this.serviceCategoryId = serviceCategoryId;
        this.postCode = postCode;
    }

    public boolean getArchived() {
        return this.archived;
    }
}
