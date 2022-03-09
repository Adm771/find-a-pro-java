package com.group.findapro.communication.request.controller;

import com.group.findapro.communication.request.model.Request;
import com.group.findapro.communication.request.repository.RequestRepository;
import com.group.findapro.communication.request.service.RequestService;
import com.group.findapro.exeptcions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "*")
public class RequestController {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    RequestService requestService;


    // GET ALL REQUEST
    @GetMapping("requests")
    public List<Request> getAllRequest() {
        return this.requestRepository.findAll();
    }

    // GET REQUEST BY ID
    @GetMapping("/request/{id}")
    public ResponseEntity<Request> getRequestById(@PathVariable(value = "id") Long requestId)
            throws ResourceNotFoundException {
        Request request = requestRepository.findById(requestId)
                .orElseThrow(() -> new ResourceNotFoundException("Request not found for this id :: " + requestId));
        return ResponseEntity.ok().body(request);
    }

    // ADD REQUEST
    @PostMapping("requests")
    public Request createRequest(@RequestBody Request request) {
        return this.requestRepository.save(request);
    }

    // UPDATE REQUEST widziałem tutaj @Valid przed request body ale nie działa obecnie wcale ten @
    @PutMapping("/request/{id}")
    public ResponseEntity<Request> updateRequest(@PathVariable(value = "id") Long requestId,
                                                  @RequestBody Request requestDetails) throws ResourceNotFoundException {
        Request request = requestRepository.findById(requestId)
                .orElseThrow(() -> new ResourceNotFoundException("Request not found for this id :: " + requestId));

        request.setTitle(requestDetails.getTitle());
        request.setDescription(requestDetails.getDescription());
        request.setPayment(requestDetails.getPayment());
        // NIE MA OPCJI OBECNIE ZMIENIA ARCHIVED

        return ResponseEntity.ok(this.requestRepository.save(request));
    }

    // DELETE REQUEST
    @DeleteMapping("/request/{id}")
    public Map<String, Boolean> deleteRequest(@PathVariable(value = "id") Long requestId)
            throws ResourceNotFoundException {
        Request request = requestRepository.findById(requestId)
                .orElseThrow(() -> new ResourceNotFoundException("Request not found for this id :: " + requestId));

        requestRepository.delete(request);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping("/requests/{userId}")
    public List<Request> getRequestsByUserId(@PathVariable(value = "userId") Long userId)
            throws ResourceNotFoundException{
        return requestService.getRequestsByUserId(userId);
    }
}