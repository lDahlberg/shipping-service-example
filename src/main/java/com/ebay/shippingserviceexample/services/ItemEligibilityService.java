package com.ebay.shippingserviceexample.services;

import com.ebay.shippingserviceexample.dtos.requests.ItemUpForEligibility;
import com.ebay.shippingserviceexample.factory.RuleFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemEligibilityService {

    private RuleFactory ruleFactory;

    @Autowired
    public ItemEligibilityService(RuleFactory ruleFactory) {
        this.ruleFactory = ruleFactory;
    }

    public boolean checkItemEligibility(ItemUpForEligibility item) {
        return ruleFactory.getDefaultProducts().stream()
                .allMatch(service -> service.isEligible(item));
    }
}
