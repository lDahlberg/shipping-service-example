package com.ebay.shippingserviceexample.services.eligibleServices.impl;

import com.ebay.shippingserviceexample.daos.Price;
import com.ebay.shippingserviceexample.dtos.requests.ItemUpForEligibility;
import com.ebay.shippingserviceexample.repository.PriceRepository;
import com.ebay.shippingserviceexample.services.eligibleServices.EligibleProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PriceService implements EligibleProductService {

    @Value("${default.priceValue}")
    private double defaultPrice;

    private PriceRepository priceRepository;

    @Autowired
    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public boolean isEligible(ItemUpForEligibility itemUpForEligibility) {
        // This should be cached and only changed during admin updates
        Price price = priceRepository.findCurrentPrice();

        if(price == null) {
            return itemUpForEligibility.getPrice() >= defaultPrice;
        }
        return itemUpForEligibility.getPrice() >= price.getValue();
    }
}
