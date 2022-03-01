package com.group.findapro.communication.request.service;

import com.group.findapro.communication.request.model.Request;
import com.group.findapro.communication.request.repository.RequestRepository;
import com.group.findapro.communication.review.Review;
import com.group.findapro.exeptcions.ResourceNotFoundException;
import com.group.findapro.user.standard_user.model.User;
import com.group.findapro.user.standard_user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@AllArgsConstructor
@Service
public class RequestService {

    private RequestRepository requestRepository;
    private UserRepository userRepository;


    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    public ResponseEntity<Request> getRequestById(Long requestId) throws ResourceNotFoundException {
        Request request = requestRepository.findById(requestId)
                .orElseThrow(() -> new ResourceNotFoundException("Request not found for this id :: " + requestId));
        return ResponseEntity.ok().body(request);
    }

    public Request createRequest(Request request) {return requestRepository.save(request);}

    public ResponseEntity<Request> updateRequest(Long requestId, Request requestDetails) throws ResourceNotFoundException {
        Request request = requestRepository.findById(requestId)
                .orElseThrow(() -> new ResourceNotFoundException("Request not found for this id :: " + requestId));

        request.setTitle(requestDetails.getTitle());
        request.setDescription(requestDetails.getDescription());
        request.setPayment(requestDetails.getPayment());
        // NIE MA OPCJI OBECNIE ZMIENIA ARCHIVED

        return ResponseEntity.ok(this.requestRepository.save(request));
    }

    public Map<String, Boolean> deleteRequest(Long requestId) throws ResourceNotFoundException {
        Request request = requestRepository.findById(requestId)
                .orElseThrow(() -> new ResourceNotFoundException("Request not found for this id :: " + requestId));

        requestRepository.delete(request);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    public List<Request> getRequestForUser(long userId) throws ResourceNotFoundException {
        User user =  userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Request not found for this id :: " + userId));
        return user.getRequests();
    }
}

