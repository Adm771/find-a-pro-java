package com.group.findapro.communication.offer.controller;

import com.group.findapro.communication.offer.model.Offer;
import com.group.findapro.communication.offer.service.OfferService;
import com.group.findapro.communication.review.Review;
import com.group.findapro.exeptcions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin
public class OfferController {



    @Autowired
    private OfferService offerService;


    // GET ALL OFFERS
    @GetMapping("offers")
    public List<Offer> getAllOffers(){return this.offerService.getAllOffers(); }

    // GET OFFER BY ID
    @GetMapping("/offer/{id}")
    public ResponseEntity<Offer> getOfferById(@PathVariable(value = "id") Long offerId)
            throws ResourceNotFoundException {
        return this.offerService.getOfferById(offerId);
    }

    // ADD OFFER
    @PostMapping("offers")
    public Offer createOffer(@RequestBody Offer offer) {
        return this.offerService.createOffer(offer);
    }

    // UPDATE OFFER widziałem tutaj @Valid przed request body ale nie działa obecnie wcale ten @
    @PutMapping("/offers/{id}")
    public ResponseEntity<Offer> updateOffer(@PathVariable(value = "id") Long offerId,
                                               @RequestBody Offer offerDetails) throws ResourceNotFoundException {

        return this.offerService.updateOffer(offerId,offerDetails);
    }
    // DELETE OFFER
    @DeleteMapping("/offers/{id}")
    public Map<String, Boolean> deleteOffer(@PathVariable(value = "id") Long offerId)
            throws ResourceNotFoundException {
        return offerService.deleteOffer(offerId);
    }

    @GetMapping("/users/offer/{userId}")
    public List<Offer> getOfferForUser(@PathVariable(value = "userId") Long userId)
            throws ResourceNotFoundException {
        return offerService.getOffersForUser(userId);
    }




}
