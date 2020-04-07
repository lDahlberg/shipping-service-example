package com.ebay.shippingserviceexample.controllers;

import com.ebay.shippingserviceexample.dtos.requests.ItemUpForEligibility;
import com.ebay.shippingserviceexample.dtos.responses.ItemEligibilityWrapper;
import com.ebay.shippingserviceexample.services.ItemEligibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shipping-eligibility")
public class ShippingEligibilityController {

    private ItemEligibilityService itemEligibilityService;

    @Autowired
    public ShippingEligibilityController(ItemEligibilityService itemEligibilityService) {
        this.itemEligibilityService = itemEligibilityService;
    }

    @PostMapping
    public ResponseEntity<ItemEligibilityWrapper> checkItemEligibility(ItemUpForEligibility item) {
        itemEligibilityService.checkItemEligibility(item);
        return ResponseEntity.ok(new ItemEligibilityWrapper(true, item));
    }
}
