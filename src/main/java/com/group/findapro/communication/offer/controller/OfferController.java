package com.group.findapro.communication.offer.controller;

import com.group.findapro.communication.offer.model.Offer;
import com.group.findapro.communication.offer.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offers")
@CrossOrigin
public class OfferController {

    private OfferService offerService;

    @Autowired
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping
    public List<Offer> getAllOffers(){ return offerService.getAllOffers(); }

    @PostMapping
    public void addOffer(@RequestBody Offer newOffer) { offerService.addOffer(newOffer); }

//    @GetMapping()
//    public List<Offer> getOffersByserviceIdAndPostCode(@RequestParam int serviceId, @RequestParam String postCode){
//        return offerService.getOffersByserviceIdAndPostCode(serviceId, postCode);
//    }
}
