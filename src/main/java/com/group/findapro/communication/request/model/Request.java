package com.group.findapro.communication.request.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Table(name = "Requests")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",
            updatable = false)
    private Long requestId;

    @Column(name = "request_title",
            columnDefinition = "VARCHAR(100)")
    private String title;

    @Column(name = "payment")
    private double payment;

    @Column(name = "request_description",
            columnDefinition = "VARCHAR(800)")
    private String description;

    @Column(name = "published_on")
    private LocalDateTime publishedOn;

    @Column(name = "archived",
            columnDefinition= "BOOLEAN default false"
    )
    private boolean archived;

    @Column(name = "service_category",
            nullable = false)
    private int serviceCategoryId;

    @Column(name = "post_code")
    private String postCode;

    @Column(name = "day",
            nullable = false,
            columnDefinition = "DATE")
    private LocalDate daySlot;

    @Column(name = "time",
            nullable = false,
            columnDefinition = "TIME")
    private LocalTime timeSlot;

    @Column(name = "user_id",
            updatable = false)
    private Long userId;

    @Column(name = "offer_id"
    )
    private Long offerId;

    @Column(name = "confirmed",
            columnDefinition= "BOOLEAN default false"
    )
    private boolean confirmed;

    public Request(String title, double payment, String description, LocalDateTime publishedOn, int serviceCategoryId, String postCode, LocalDate daySlot, LocalTime timeSlot) {
        this.title = title;
        this.payment = payment;
        this.description = description;
        this.publishedOn = publishedOn;
        this.serviceCategoryId = serviceCategoryId;
        this.postCode = postCode;
        this.daySlot = daySlot;
        this.timeSlot = timeSlot;
    }

    public boolean getArchived() {
        return this.archived;
    }
}
