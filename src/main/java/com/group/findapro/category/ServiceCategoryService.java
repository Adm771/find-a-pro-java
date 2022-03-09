package com.group.findapro.category;

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

    public ServiceCategoryService() {
    }
}
