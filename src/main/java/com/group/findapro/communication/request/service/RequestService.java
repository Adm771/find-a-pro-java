package com.group.findapro.communication.request.service;

import com.group.findapro.communication.request.model.Request;
import com.group.findapro.communication.request.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {

    private RequestRepository requestRepository;

    @Autowired
    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public List<Request> getAllRequests() { return requestRepository.findAll(); }

    public void addRequest(Request newRequest) {
        System.out.println(newRequest);
        requestRepository.save(newRequest);
    }

//    public List<Request> getRequestsByCustomerId(Long customerId) { return requestRepository.findAllByCustomerId(customerId);
//    }
}

