package com.ebay.shippingserviceexample.services.eligibleServices.impl;

import com.ebay.shippingserviceexample.dtos.requests.ItemUpForEligibility;
import com.ebay.shippingserviceexample.repository.SellerRepository;
import com.ebay.shippingserviceexample.daos.Seller;
import com.ebay.shippingserviceexample.services.eligibleServices.EligibleProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService implements EligibleProductService {
    private SellerRepository sellerRepository;

    @Autowired
    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public boolean isEligible(ItemUpForEligibility itemUpForEligibility) {
        Seller seller = sellerRepository.findSellerByName(itemUpForEligibility.getSeller());

        if(seller ==  null) {
            return false;
        }
        return seller.isSellerEnrolled();
    }
}
