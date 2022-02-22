package com.group.findapro.communication.review.model;

import javax.persistence.*;

@Entity
@Table(name="Reviews")
public class Review {

    @Id
    @GeneratedValue
    private long id;

    @Column(
            columnDefinition = "TEXT"
    )
    private String message;
    private long customerId;
    private long handymanId;
    private float rating;


    public Review(String message, long customerId, long handymanId, float rating) {
        this.message = message;
        this.customerId = customerId;
        this.handymanId = handymanId;
        this.rating = rating;
    }

    public Review(String message, long customerId, long handymanId) {
        this.message = message;
        this.customerId = customerId;
        this.handymanId = handymanId;
    }

    public Review() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getHandymanId() {
        return handymanId;
    }

    public void setHandymanId(long handymanId) {
        this.handymanId = handymanId;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
