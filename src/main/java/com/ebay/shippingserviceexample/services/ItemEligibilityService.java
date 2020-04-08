package com.ebay.shippingserviceexample.services;

import com.ebay.shippingserviceexample.dtos.requests.ItemUpForEligibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemEligibilityService {

    private RuleService ruleService;

    @Autowired
    public ItemEligibilityService(RuleService ruleService) {
        this.ruleService = ruleService;
    }

    public boolean checkItemEligibility(ItemUpForEligibility item) {
        return ruleService.getDefaultProducts().stream()
                .allMatch(service -> service.isEligible(item));
    }
}
