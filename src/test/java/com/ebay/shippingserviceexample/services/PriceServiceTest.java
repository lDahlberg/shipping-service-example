package com.ebay.shippingserviceexample.services;

import com.ebay.shippingserviceexample.dtos.requests.ItemUpForEligibility;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PriceServiceTest {
    @InjectMocks
    private PriceService subject;

    @Test
    void isEligibleReturnsTrueForGreaterPricedItem() {
        String TITLE = "Hitchhiker's Guide to the Galaxy";
        String SELLER_NAME = "Ebay";
        double PRICE = 15.99;
        int CATEGORY = 6;
        ItemUpForEligibility item = new ItemUpForEligibility(TITLE, SELLER_NAME,  CATEGORY, PRICE);
        boolean result = subject.isEligible(item);

        assertTrue(result, "Should return true when price matches");
    }
}