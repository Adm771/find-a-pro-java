package com.group.findapro.communication.offer.service;

import com.group.findapro.communication.offer.model.Offer;
import com.group.findapro.communication.offer.repository.OfferRepository;
import com.group.findapro.exeptcions.ResourceNotFoundException;
import com.group.findapro.user.standard_user.model.User;
import com.group.findapro.user.standard_user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@AllArgsConstructor
@Service
public class OfferService {

    private final OfferRepository offerRepository;

    private final UserRepository userRepository;


    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

    public ResponseEntity<Offer> getOfferById(Long offerId) throws ResourceNotFoundException {
        Offer offer = offerRepository.findById(offerId)
                .orElseThrow(() -> new ResourceNotFoundException("Offer not found for this id :: " + offerId));
        return ResponseEntity.ok().body(offer);
    }

    public Offer createOffer(Offer offer){return this.offerRepository.save(offer);}

    public ResponseEntity<Offer> updateOffer(long offerId, Offer offerDetails) throws ResourceNotFoundException {
        Offer offer = offerRepository.findById(offerId)
                .orElseThrow(() -> new ResourceNotFoundException("Offer not found for this id :: " + offerId));

        offer.setTitle(offerDetails.getTitle());
        offer.setDescription(offerDetails.getDescription());
        offer.setPayment(offerDetails.getPayment());

        return ResponseEntity.ok(this.offerRepository.save(offer));
    }

    public Map<String, Boolean> deleteOffer(Long offerId) throws ResourceNotFoundException {
        Offer offer = offerRepository.findById(offerId)
                .orElseThrow(() -> new ResourceNotFoundException("Offer not found for this id :: " + offerId));

        offerRepository.delete(offer);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    public List<Offer> getOffersForUser(long userId) throws ResourceNotFoundException{
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found for this id :: " + userId));
        return user.getOffers();
    }

    // DTO SERVIS WITH OFFER WITH USER ID
}
