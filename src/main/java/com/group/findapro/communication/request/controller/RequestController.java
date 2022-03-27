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
    private RequestService requestService;

    // GET ALL REQUEST
    @GetMapping("/requests")
    public List<Request> getAllRequest() {
        return this.requestService.getAllRequests();
    }

    // GET REQUEST BY ID
    @GetMapping("/requests/{id}")
    public ResponseEntity<Request> getRequestById(@PathVariable(value = "id") Long requestId)
            throws ResourceNotFoundException {
        Request request = requestService.getRequestById(requestId);
        return ResponseEntity.ok().body(request);
    }

    // ADD REQUEST
    @PostMapping("/requests")
    public void createRequest(@RequestBody Request newRequest) {
        this.requestService.addRequest(newRequest);
    }

    // UPDATE REQUEST
    @PutMapping("/requests/{id}")
    public ResponseEntity<Request> updateRequest(@PathVariable(value = "id") Long requestId,
                                                  @RequestBody Request request) throws ResourceNotFoundException {
        request = requestService.updateRequest(requestId, request);

        return ResponseEntity.ok(request);
    }

    // DELETE REQUEST
    @DeleteMapping("/requests/{id}")
    public ResponseEntity<Boolean> deleteRequest(@PathVariable(value = "id") Long requestId)
            throws ResourceNotFoundException {

        requestService.deleteRequest(requestId);
        return ResponseEntity.ok(true);
    }

    // GET REQUEST BY USER ID
    @GetMapping("/requests/user/{userId}")
    public List<Request> getRequestsByUserId(@PathVariable(value = "userId") Long userId)
            throws ResourceNotFoundException{
        return requestService.getRequestsByUserId(userId);
    }
}