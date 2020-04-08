package com.ebay.shippingserviceexample.services;

import com.ebay.shippingserviceexample.EligibleProductService;
import com.ebay.shippingserviceexample.dtos.requests.ItemUpForEligibility;
import com.ebay.shippingserviceexample.repository.SellerRepository;
import daos.Seller;
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
        Seller seller = sellerRepository.get(itemUpForEligibility.getSeller());

        if (seller == null) {
            return false;
        }
        return seller.isSellerEnrolled();
    }
}
