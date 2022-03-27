package com.group.findapro.communication.request.service;

import com.group.findapro.communication.offer.model.Offer;
import com.group.findapro.communication.request.model.Request;
import com.group.findapro.communication.request.repository.RequestRepository;
import com.group.findapro.exeptcions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class RequestService {

    private RequestRepository requestRepository;

    @Autowired
    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    public Request getRequestById(Long requestId) throws ResourceNotFoundException {
        Request request =  requestRepository.findById(requestId)
                .orElseThrow(() -> new ResourceNotFoundException("Request not found for this id :: " + requestId));
        return request;
    }

    public void addRequest(Request newRequest) {
        requestRepository.save(newRequest);
    }

    @Transactional
    public Request updateRequest(long requestId, Request request) throws ResourceNotFoundException {
        System.out.println("Fetching request with id = " + requestId);
        Request requestEdited = requestRepository.findById(requestId)
                .orElseThrow(() -> new ResourceNotFoundException("Request not found for this id :: " + requestId));
        System.out.println("Updating of " + requestEdited);

        requestEdited.setTitle(request.getTitle());
        requestEdited.setPayment(request.getPayment());
        requestEdited.setDescription(request.getDescription());
        requestEdited.setArchived(request.getArchived());
        requestEdited.setServiceCategoryId(request.getServiceCategoryId());
        requestEdited.setPostCode(request.getPostCode());
        requestEdited.setDaySlot(request.getDaySlot());
        requestEdited.setTimeSlot(request.getTimeSlot());

        System.out.println("Updated to " + requestEdited);
        // unnecessary because of "dirty checking"
        requestRepository.save(requestEdited);
        return requestEdited;
    }

    public List<Request> getRequestsByUserId(Long userId) {
        return requestRepository.findAllByUserId(userId);
    }


    public boolean deleteRequest(Long requestId) throws ResourceNotFoundException {
        Request request =  requestRepository.findById(requestId)
                .orElseThrow(() -> new ResourceNotFoundException("Request not found for this id :: " + requestId));
        requestRepository.deleteById(requestId);
        return true;
    }
}

