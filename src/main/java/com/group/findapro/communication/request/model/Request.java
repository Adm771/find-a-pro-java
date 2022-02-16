package com.group.findapro.communication.request.model;

import com.group.findapro.communication.Communication;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="Requests")
public class Request extends Communication {

    private long customerId;

    public Request(int serviceId, LocalDate daySlot, LocalTime timeSlot, float hourlySalaryRate, String postCode, boolean active, String message, long customerId) {
        super(serviceId, daySlot, timeSlot, hourlySalaryRate, postCode, active, message);
        this.customerId = customerId;
    }

    public Request() {
    }
}