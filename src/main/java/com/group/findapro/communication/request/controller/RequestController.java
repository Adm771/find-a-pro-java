package com.group.findapro.communication.request.controller;

import com.group.findapro.communication.request.model.Request;
import com.group.findapro.communication.request.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requests")
@CrossOrigin
public class RequestController {

    private RequestService requestService;

    @Autowired
    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping
    public List<Request> getAllRequests() { return requestService.getAllRequests(); }

    @PostMapping
    public void addRequest (@RequestBody Request newRequest) { requestService.addRequest(newRequest);}

}
