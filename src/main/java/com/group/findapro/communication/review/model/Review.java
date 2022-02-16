package com.group.findapro.communication.review.model;

import com.group.findapro.communication.Communication;

public class Review extends Communication {

    private long customerId;
    private long handymanId;

    public Review(long id, int serviceId, String postCode, String message, long customerId, long handymanId) {
        super(id, serviceId, postCode, message);
        this.customerId = customerId;
        this.handymanId = handymanId;
    }
}
