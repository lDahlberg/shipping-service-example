package com.ebay.shippingserviceexample.services;

import com.ebay.shippingserviceexample.dtos.requests.ItemUpForEligibility;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ItemEligibilityServiceTest {

    @InjectMocks
    ItemEligibilityService subject;

    private static final String SELLER = "Peter";
    private static final String TITLE = "The Pink Panther";
    private static final int CATEGORY = 1964;
    private static final double PRICE = 19.99;

    @Test
    void checkItemEligibilityReturnsTrueWhenSellerIsInProgram() {
        ItemUpForEligibility item = new ItemUpForEligibility(TITLE, SELLER,  CATEGORY, PRICE);
        boolean result = subject.checkItemEligibility(item);

        boolean expected = true;
        assertTrue(result, "Should return true when seller is in program");
    }
}