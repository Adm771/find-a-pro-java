package com.group.findapro.communication.offer.model;

import com.group.findapro.communication.Communication;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Offers")

public class Offer extends Communication {

    private long handymanId;

    @ElementCollection
    public List<Integer> serviceId;

    public Offer(List<Integer> serviceId, float hourlySalaryRate, String postCode, boolean active, String message, long handymanId) {
        super(hourlySalaryRate, postCode, active, message);
        this.serviceId = serviceId;
        this.handymanId = handymanId;
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
