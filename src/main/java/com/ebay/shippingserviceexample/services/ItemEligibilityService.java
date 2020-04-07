package com.ebay.shippingserviceexample.services;

import com.ebay.shippingserviceexample.dtos.requests.ItemUpForEligibility;
import org.springframework.stereotype.Service;

@Service
public class ItemEligibilityService {

    public boolean checkItemEligibility(ItemUpForEligibility item) {
        return false;
    }
}
