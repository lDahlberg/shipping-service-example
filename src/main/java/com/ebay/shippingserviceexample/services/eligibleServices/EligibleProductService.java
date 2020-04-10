package com.ebay.shippingserviceexample.services.eligibleServices;

import com.ebay.shippingserviceexample.dtos.requests.ItemUpForEligibility;

public interface EligibleProductService {
    boolean isEligible(ItemUpForEligibility itemUpForEligibility);
}
