package com.group.findapro.communication.request.model;

import com.group.findapro.communication.Communication;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="Requests")
public class Request extends Communication {

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

    public Request(int serviceId, LocalDate daySlot, LocalTime timeSlot, float hourlySalaryRate, String postCode, boolean active, String message, long customerId) {
        super(hourlySalaryRate, postCode, active, message);
        this.serviceId = serviceId;
        this.daySlot = daySlot;
        this.timeSlot = timeSlot;
        this.customerId = customerId;
    }

    public Request() {
    }
}