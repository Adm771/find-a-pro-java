package com.group.findapro.category.repository;

import com.group.findapro.category.model.ServiceCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceCategoryRepository extends JpaRepository<ServiceCategory, Long> {
}
