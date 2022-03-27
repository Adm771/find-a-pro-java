package com.group.findapro.communication.offer.service;

import com.group.findapro.communication.offer.model.Offer;
import com.group.findapro.communication.offer.repository.OfferRepository;
import com.group.findapro.communication.request.model.Request;
import com.group.findapro.communication.request.service.RequestService;
import com.group.findapro.exeptcions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OfferService {

    private OfferRepository offerRepository;
    private RequestService requestService;

    @Autowired
    public OfferService(OfferRepository offerRepository, RequestService requestService) {
        this.offerRepository = offerRepository;
        this.requestService = requestService;
    }

    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

    public Offer getOfferById(Long offerId) throws ResourceNotFoundException {
        Offer offer = offerRepository.findById(offerId)
                .orElseThrow(() -> new ResourceNotFoundException("Offer not found for this id :: " + offerId));
        return  offer;
    }

    public void addOffer(Offer newOffer) { offerRepository.save(newOffer); }

    @Transactional
    public Offer updateOffer(long offerId, Offer offer) throws ResourceNotFoundException {
        System.out.println("Fetching offer with id = " + offerId);
        Offer offerEdited = offerRepository.findById(offerId)
                .orElseThrow(() -> new ResourceNotFoundException("Offer not found for this id :: " + offerId));
        System.out.println("Updating of " + offerEdited);

        offerEdited.setTitle(offer.getTitle());
        offerEdited.setPayment(offer.getPayment());
        offerEdited.setDescription(offer.getDescription());
        offerEdited.setArchived(offer.getArchived());
        offerEdited.setServiceCategoryId(offer.getServiceCategoryId());

        System.out.println("Updated to " + offerEdited);
        // unnecessary because of "dirty checking"
        offerRepository.save(offerEdited);
        return offerEdited;
    }

    public boolean deleteOffer(long offerId) throws ResourceNotFoundException {
        Offer offer = offerRepository.findById(offerId)
                .orElseThrow(() -> new ResourceNotFoundException("Offer not found for this id :: " + offerId));
        offerRepository.deleteById(offerId);
        return true;
    }

    @Transactional
    public List<Offer> getMatchingOffers(Long requestId) throws ResourceNotFoundException {
        Request request = requestService.getRequestById(requestId);

        double payment = request.getPayment();
        int serviceCategoryId = request.getServiceCategoryId();
        String postCode = request.getPostCode();

        List<Offer> matchingOffers = offerRepository.getMatchingOffers(payment, serviceCategoryId, postCode);

        return matchingOffers;
    }
}
