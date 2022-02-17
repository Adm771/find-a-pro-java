package com.group.findapro.communication;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.time.LocalTime;

@MappedSuperclass
public abstract class Communication {

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
    private String postCode;
    private boolean active;

    @Column(
            columnDefinition = "TEXT"
    )
    private String message;

    public Communication(float hourlySalaryRate, String postCode, boolean active, String message) {
        this.hourlySalaryRate = hourlySalaryRate;
        this.postCode = postCode;
        this.active = active;
        this.message = message;
    }

    public Communication(long id, String postCode, String message) {
        this.id = id;
        this.postCode = postCode;
        this.message = message;
    }

    public Communication() {
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
