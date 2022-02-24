package com.group.findapro.communication.offer.model;

import lombok.*;

import javax.persistence.*;

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
    private long payment;

    @Column(name = "offer_description")
    private String description;

    @Column(name = "published_on")
    private java.sql.Date publishedOn;

    @Column(name = "archived")
    private boolean archived;

}
