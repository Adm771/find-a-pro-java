package com.group.findapro.user.pro_user.service;

import com.group.findapro.user.pro_user.model.Handyman;
import com.group.findapro.user.pro_user.repository.HandymanRepository;
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
