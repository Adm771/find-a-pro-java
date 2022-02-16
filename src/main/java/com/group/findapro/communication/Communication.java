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
    private float hourlySalaryRate;
    private String postCode;
    private boolean active;

    @Column(
            nullable = true,
            columnDefinition = "TEXT"
    )
    private String message;

    public Communication(int serviceId, LocalDate daySlot, LocalTime timeSlot, float hourlySalaryRate, String postCode, boolean active, String message) {
        this.serviceId = serviceId;
        this.daySlot = daySlot;
        this.timeSlot = timeSlot;
        this.hourlySalaryRate = hourlySalaryRate;
        this.postCode = postCode;
        this.active = active;
        this.message = message;
    }

    public Communication(long id, int serviceId, String postCode, String message) {
        this.id = id;
        this.serviceId = serviceId;
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
