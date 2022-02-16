package com.group.findapro.user.handyman.service;

import com.group.findapro.user.handyman.model.Handyman;
import com.group.findapro.user.handyman.repository.HandymanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HandymanService {

    HandymanRepository handymanRepository;

    @Autowired
    public HandymanService(HandymanRepository handymanRepository) {
        this.handymanRepository = handymanRepository;
    }

    public List<Handyman> getAllHandymen() { return handymanRepository.findAll(); }
}
