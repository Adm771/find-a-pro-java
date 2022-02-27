package com.group.findapro.communication.offer.service;

import com.group.findapro.communication.offer.model.Offer;
import com.group.findapro.communication.offer.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {

    private OfferRepository offerRepository;

    @Autowired
    public OfferService(OfferRepository offerRepository) {
    this.offerRepository = offerRepository;
    }

    public List<Offer> getAllOffers() { return offerRepository.findAll();
    }

    public void addOffer(Offer newOffer) {
    offerRepository.save(newOffer);
    }

//    public List<Offer> getOffersByserviceIdAndPostCode(int serviceId, String postCode) {
//       return offerRepository.findAllByServiceIdAndPostCode(serviceId, postCode);
//    }
}
