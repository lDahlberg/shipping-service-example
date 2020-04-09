package com.ebay.shippingserviceexample.controllers;

import com.ebay.shippingserviceexample.dtos.requests.ItemUpForEligibility;
import com.ebay.shippingserviceexample.dtos.responses.ItemEligibilityWrapper;
import com.ebay.shippingserviceexample.services.ItemEligibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shipping-eligibility")
public class ShippingEligibilityController {

    private ItemEligibilityService itemEligibilityService;

    @Autowired
    public ShippingEligibilityController(ItemEligibilityService itemEligibilityService) {
        this.itemEligibilityService = itemEligibilityService;
    }

    @PostMapping
    public ResponseEntity<ItemEligibilityWrapper> checkItemEligibility(@RequestBody ItemUpForEligibility item) {
        if(item.getSeller() == null) {
            return ResponseEntity.badRequest().body(null);
        }
        if(item.getCategory() < 0) {
            return ResponseEntity.badRequest().body(null);
        }
        if(item.getPrice() < 0.0) {
            return ResponseEntity.badRequest().body(null);
        }
        boolean isEligible = itemEligibilityService.checkItemEligibility(item);
        return ResponseEntity.ok(new ItemEligibilityWrapper(isEligible, item));
    }
}
