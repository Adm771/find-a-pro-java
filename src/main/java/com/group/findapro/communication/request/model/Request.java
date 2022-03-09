package com.group.findapro.communication.request.model;

import com.group.findapro.user.standard_user.model.User;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
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

    // ILOSC CHAR W COLUMN DEFINITION
    @Column(name = "request_title",
            columnDefinition = "VARCHAR(800)")
    private String title;

    @Column(name = "payment")
    private double payment;

    @Column(name = "request_description")
    private String description;

    @Column(name = "published_on")
    private LocalDateTime publishedOn;

    // redundant because phone number will be taken from user
//    @Column(name = "phone_number")
//    private long phoneNumber;

    @Column(name = "archived",
            columnDefinition= "BOOLEAN default false"
    )
    private boolean archived;


    //added
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

    @Column(name = "handyman_id"
    )
    private Long handymanId;

    @Column(name = "confirmed",
            columnDefinition= "BOOLEAN default false"
    )
    private boolean confirmed;

    public Request(String title, double payment, String description, LocalDateTime publishedOn, boolean archived, int serviceCategoryId, String postCode, LocalDate daySlot, LocalTime timeSlot, Long userId, Long handymanId, boolean confirmed) {
        this.title = title;
        this.payment = payment;
        this.description = description;
        this.publishedOn = publishedOn;
        this.archived = archived;
        this.serviceCategoryId = serviceCategoryId;
        this.postCode = postCode;
        this.daySlot = daySlot;
        this.timeSlot = timeSlot;
        this.userId = userId;
        this.handymanId = handymanId;
        this.confirmed = confirmed;
    }
}
