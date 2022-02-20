package com.group.findapro.communication.offer.model;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name="Offers")

public class Offer {

    @Id
    @GeneratedValue
    @Column(
            updatable = false,
            unique = true
    )
    private long id;

    @Column(
            nullable = false
    )
    private float hourlySalaryRate;

    @Column(
            columnDefinition = "TEXT"
    )
    private String postCode;

    @Column(
            columnDefinition = "TEXT"
    )
    private String message;

    private long handymanId;

    @ElementCollection
    public List<Integer> serviceId;

    public Offer(float hourlySalaryRate, String postCode, String message, long handymanId, List<Integer> serviceId) {
        this.hourlySalaryRate = hourlySalaryRate;
        this.postCode = postCode;
        this.message = message;
        this.handymanId = handymanId;
        this.serviceId = serviceId;
    }

    public Offer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getHourlySalaryRate() {
        return hourlySalaryRate;
    }

    public void setHourlySalaryRate(float hourlySalaryRate) {
        this.hourlySalaryRate = hourlySalaryRate;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getHandymanId() {
        return handymanId;
    }

    public void setHandymanId(long handymanId) {
        this.handymanId = handymanId;
    }

    public List<Integer> getServiceId() {
        return serviceId;
    }

    public void setServiceId(List<Integer> serviceId) {
        this.serviceId = serviceId;
    }
}
