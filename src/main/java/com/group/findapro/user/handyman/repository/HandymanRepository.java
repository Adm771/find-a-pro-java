package com.group.findapro.user.handyman.repository;

import com.group.findapro.user.handyman.model.Handyman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HandymanRepository extends JpaRepository<Handyman, Long> {
}
