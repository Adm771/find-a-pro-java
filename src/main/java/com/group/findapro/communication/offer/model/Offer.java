package com.group.findapro.communication.offer.model;

import com.group.findapro.communication.Communication;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="Offers")
public class Offer extends Communication {

    private long handymanId;

    public Offer(int serviceId, LocalDate daySlot, LocalTime timeSlot, float hourlySalaryRate, String postCode, boolean active, String message, long handymanId) {
        super(serviceId, daySlot, timeSlot, hourlySalaryRate, postCode, active, message);
        this.handymanId = handymanId;
    }

    public Offer(int serviceId, LocalDate parse, int timeSlot, int hourlySalaryRate, String se1, boolean active, String painting_the_wall, long handymanId) {
        super();
    }

    public Offer() {
    }

    public long getHandymanId() {
        return handymanId;
    }

    public void setHandymanId(long handymanId) {
        this.handymanId = handymanId;
    }

    @Override
    public void setId(long id) {
        super.setId(id);
    }
}
