package com.group.findapro.communication.offer.controller;

import com.group.findapro.communication.offer.model.Offer;
import com.group.findapro.communication.offer.repository.OfferRepository;
import com.group.findapro.exeptcions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin
public class OfferController {

    @Autowired
    private OfferRepository offerRepository;


    // GET ALL OFFERS
    @GetMapping("offers")
    public List<Offer> getAllOffers(){return this.offerRepository.findAll(); }

    // GET OFFER BY ID
    @GetMapping("/offer/{id}")
    public ResponseEntity<Offer> getOfferById(@PathVariable(value = "id") Long offerId)
            throws ResourceNotFoundException {
        Offer offer = offerRepository.findById(offerId)
                .orElseThrow(() -> new ResourceNotFoundException("Offer not found for this id :: " + offerId));
        return ResponseEntity.ok().body(offer);
    }

    // ADD OFFER
    @PostMapping("offers")
    public Offer createOffer(@RequestBody Offer offer) {
        return this.offerRepository.save(offer);
    }

    // UPDATE OFFER widziałem tutaj @Valid przed request body ale nie działa obecnie wcale ten @
    @PutMapping("/offers/{id}")
    public ResponseEntity<Offer> updateOffer(@PathVariable(value = "id") Long offerId,
                                               @RequestBody Offer offerDetails) throws ResourceNotFoundException {
        Offer offer = offerRepository.findById(offerId)
                .orElseThrow(() -> new ResourceNotFoundException("Offer not found for this id :: " + offerId));

        offer.setTitle(offerDetails.getTitle());
        offer.setDescription(offerDetails.getDescription());
        offer.setPayment(offerDetails.getPayment());
        // NIE MA OPCJI OBECNIE ZMIENIA ARCHIVED

        return ResponseEntity.ok(this.offerRepository.save(offer));
    }
    // DELETE OFFER
    @DeleteMapping("/offers/{id}")
    public Map<String, Boolean> deleteOffer(@PathVariable(value = "id") Long offerId)
            throws ResourceNotFoundException {
        Offer offer = offerRepository.findById(offerId)
                .orElseThrow(() -> new ResourceNotFoundException("Offer not found for this id :: " + offerId));

        offerRepository.delete(offer);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }





}
