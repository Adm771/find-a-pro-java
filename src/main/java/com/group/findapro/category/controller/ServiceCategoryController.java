package com.group.findapro.category.controller;

import com.group.findapro.category.model.ServiceCategory;
import com.group.findapro.category.service.ServiceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin
public class ServiceCategoryController {

    ServiceCategoryService serviceCategoryService;

    @Autowired
    public ServiceCategoryController(ServiceCategoryService serviceCategoryService) {
        this.serviceCategoryService = serviceCategoryService;
    }

    @GetMapping("/services")
    public List<ServiceCategory> getAllServices() {
       return serviceCategoryService.getAllServices();
    }

}
