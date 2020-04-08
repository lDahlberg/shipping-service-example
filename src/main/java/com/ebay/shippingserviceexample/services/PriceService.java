package com.ebay.shippingserviceexample.services;

import com.ebay.shippingserviceexample.EligibleProductService;
import com.ebay.shippingserviceexample.dtos.requests.ItemUpForEligibility;

public class PriceService implements EligibleProductService {
   private final double PRICE = 10;

    @Override
    public boolean isEligible(ItemUpForEligibility itemUpForEligibility) {
        return itemUpForEligibility.getPrice() >= PRICE;
    }
}
