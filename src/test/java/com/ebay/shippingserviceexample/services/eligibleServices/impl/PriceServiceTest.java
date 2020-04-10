package com.ebay.shippingserviceexample.services.eligibleServices.impl;

import com.ebay.shippingserviceexample.daos.Price;
import com.ebay.shippingserviceexample.dtos.requests.ItemUpForEligibility;
import com.ebay.shippingserviceexample.repository.PriceRepository;
import com.ebay.shippingserviceexample.services.eligibleServices.impl.PriceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceServiceTest {
    @InjectMocks
    private PriceService subject;

    @Mock
    private PriceRepository priceRepository;

    @BeforeEach
    public void setup() {
        ReflectionTestUtils.setField(subject, "defaultPrice", 10.00);
    }

    @Test
    void isEligibleReturnsTrueForGreaterPricedItem() {
        double currentPrice = 10.00;
        when(priceRepository.findCurrentPrice()).thenReturn(new Price(currentPrice, true));
        String title = "Hitchhiker's Guide to the Galaxy";
        String sellerName = "Ebay";
        double price = 15.99;
        int category = 6;
        ItemUpForEligibility item = new ItemUpForEligibility(title, sellerName, category, price);
        boolean result = subject.isEligible(item);

        assertTrue(result, "Should return true when price is greater than current price");
    }

    @Test
    void isEligibleUsesDefaultForNoPrice() {
        when(priceRepository.findCurrentPrice()).thenReturn(null);
        String title = "Hitchhiker's Guide to the Galaxy";
        String sellerName = "Ebay";
        double price = 15.99;
        int category = 6;
        ItemUpForEligibility item = new ItemUpForEligibility(title, sellerName, category, price);
        boolean result = subject.isEligible(item);

        assertTrue(result, "Should return true for no price set as price is greater than default");
    }
}