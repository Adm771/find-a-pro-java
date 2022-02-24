package com.group.findapro.user.pro_user.repository;

import com.group.findapro.user.pro_user.model.Handyman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HandymanRepository extends JpaRepository<Handyman, Long> {
}
