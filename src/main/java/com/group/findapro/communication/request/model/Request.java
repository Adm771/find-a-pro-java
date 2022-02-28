package com.group.findapro.communication.request.model;

import com.group.findapro.user.standard_user.model.User;
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
    private java.sql.Date publishedOn;



    @Column(name = "phone_number")
    private long phoneNumber;

    @Column(name = "archived")
    private boolean archived;


}
