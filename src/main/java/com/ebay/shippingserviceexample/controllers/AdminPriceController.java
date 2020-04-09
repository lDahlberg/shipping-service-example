package com.ebay.shippingserviceexample.controllers;

import com.ebay.shippingserviceexample.daos.Price;
import com.ebay.shippingserviceexample.dtos.requests.UpdatedPrice;
import com.ebay.shippingserviceexample.services.admin.AdminPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin/price")
public class AdminPriceController {

    private AdminPriceService adminPriceService;

    @Autowired
    public AdminPriceController(AdminPriceService adminPriceService) {
        this.adminPriceService = adminPriceService;
    }

    @PutMapping
    public ResponseEntity<Price> updatePrice(@RequestBody UpdatedPrice updatedPrice) {
        // Verify admin privileges
        adminPriceService.updatePrice(updatedPrice);

        return ResponseEntity.ok(new Price(0.00, true));
    }
}
