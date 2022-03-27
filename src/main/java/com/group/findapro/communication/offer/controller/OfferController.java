package com.group.findapro.communication.offer.controller;

import com.group.findapro.communication.offer.model.Offer;
import com.group.findapro.communication.offer.service.OfferService;
import com.group.findapro.exeptcions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin
public class OfferController {

    @Autowired
    private OfferService offerService;

    // GET ALL OFFERS
    @GetMapping("/offers")
    public List<Offer> getAllOffers(){return this.offerService.getAllOffers(); }

    // GET OFFER BY ID
    @GetMapping("/offers/{id}")
    public ResponseEntity<Offer> getOfferById(@PathVariable(value = "id") Long offerId) throws ResourceNotFoundException {
        Offer offer = offerService.getOfferById(offerId);
        return ResponseEntity.ok().body(offer);
    }

    // ADD OFFER
    @PostMapping("/offers")
    public void createOffer(@RequestBody Offer offer) { this.offerService.addOffer(offer); }

    // UPDATE OFFER
    @PutMapping("/offers/{id}")
    public ResponseEntity<Offer> updateOffer(@PathVariable(value = "id") Long offerId,
                                               @RequestBody Offer offer) throws ResourceNotFoundException {
        offer = offerService.updateOffer(offerId, offer);

        return ResponseEntity.ok(offer);
    }

    // DELETE OFFER
    @DeleteMapping("/offers/{id}")
    public ResponseEntity<Boolean> deleteOffer(@PathVariable(value = "id") Long offerId) throws ResourceNotFoundException {
        offerService.deleteOffer(offerId);
        return ResponseEntity.ok(true);
    }

    // GET MATCHING OFFERS
    @GetMapping("/requests/{id}/offers")
    public List<Offer> getMatchingOffers (@PathVariable(value = "id") Long requestId) throws ResourceNotFoundException {
        return offerService.getMatchingOffers(requestId);
    }
}
