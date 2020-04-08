package com.ebay.shippingserviceexample;

import com.ebay.shippingserviceexample.dtos.requests.ItemUpForEligibility;

public interface EligibleProductService {
    boolean isEligible(ItemUpForEligibility itemUpForEligibility);
}
