package com.group.findapro.communication.request.model;

import lombok.*;

import javax.persistence.*;

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
    private Long requestId;

    @Column(name = "request_title")
    private String title;

    @Column(name = "payment")
    private long payment;

    @Column(name = "request_description")
    private String description;

    @Column(name = "published_on")
    private java.sql.Date publishedOn;

    @Column(name = "phone_number")
    private long phoneNumber;

    @Column(name = "archived")
    private boolean archived;

}
