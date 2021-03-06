package com.group.findapro.user.handyman.controller;

import com.group.findapro.user.handyman.model.Handyman;
import com.group.findapro.user.handyman.service.HandymanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/handymen")
public class HandymanController {

    HandymanService handymanService;

    @Autowired
    public HandymanController(HandymanService handymanService) {
        this.handymanService = handymanService;
    }

    public List<Handyman> getAllHandymen() { return handymanService.getAllHandymen(); }
}
