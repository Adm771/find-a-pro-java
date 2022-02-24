package com.group.findapro.communication.request.repository;

import com.group.findapro.communication.request.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

//    List<Request> findAllByCustomerId(Long customerId);
}
