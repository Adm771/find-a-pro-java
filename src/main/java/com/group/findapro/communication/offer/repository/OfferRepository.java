package com.group.findapro.communication.offer.repository;

import com.group.findapro.communication.offer.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

    @Query("select o from Offer o where o.payment <= ?1 and o.serviceCategoryId = ?2 and o.postCode = ?3")
    List<Offer> getMatchingOffers(double payment, int serviceCategoryId, String postCode);
}


