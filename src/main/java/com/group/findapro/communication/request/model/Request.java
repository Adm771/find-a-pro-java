package com.group.findapro.communication.request.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="Requests")
public class Request {

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

    private boolean active;

    @Column(
            columnDefinition = "TEXT"
    )
    private String message;

    @Column(
            columnDefinition = "INTEGER"
    )
    private int serviceId;

    @Column(
            nullable = false,
            columnDefinition = "DATE"
    )
    private LocalDate daySlot;

    @Column(
            nullable = false,
            columnDefinition = "TIME"
    )
    private LocalTime timeSlot;
    private long customerId;

    @Column(
            nullable = true,
            columnDefinition= "BIGINT default null"
    )
    private long handymanId;

    @Column(
            nullable = false,
            columnDefinition= "BOOLEAN default false"
    )
    private boolean confirmed;

    public Request(float hourlySalaryRate, String postCode, boolean active, String message, int serviceId, LocalDate daySlot, LocalTime timeSlot, long customerId) {
        this.hourlySalaryRate = hourlySalaryRate;
        this.postCode = postCode;
        this.active = active;
        this.message = message;
        this.serviceId = serviceId;
        this.daySlot = daySlot;
        this.timeSlot = timeSlot;
        this.customerId = customerId;
    }

    public Request() {
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

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public LocalDate getDaySlot() {
        return daySlot;
    }

    public void setDaySlot(LocalDate daySlot) {
        this.daySlot = daySlot;
    }

    public LocalTime getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(LocalTime timeSlot) {
        this.timeSlot = timeSlot;
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

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }
}