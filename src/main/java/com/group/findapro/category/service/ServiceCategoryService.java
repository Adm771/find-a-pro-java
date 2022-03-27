package com.group.findapro.category.service;

import com.group.findapro.category.repository.ServiceCategoryRepository;
import com.group.findapro.category.model.ServiceCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCategoryService {

    ServiceCategoryRepository serviceCategoryRepository;

    @Autowired
    public ServiceCategoryService(ServiceCategoryRepository serviceCategoryRepository) {
        this.serviceCategoryRepository = serviceCategoryRepository;
    }

    public List<ServiceCategory> getAllServices() { return serviceCategoryRepository.findAll(); }

    public void addService(ServiceCategory newService) { serviceCategoryRepository.save(newService); }

}
