package com.group.findapro.communication.offer.repository;

import com.group.findapro.communication.offer.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

//    List<Offer> findAllByServiceIdAndPostCode(int serviceId, String postCode);
}


