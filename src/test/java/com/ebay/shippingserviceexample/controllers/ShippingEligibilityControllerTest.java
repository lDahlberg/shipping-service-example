package com.ebay.shippingserviceexample.controllers;

import com.ebay.shippingserviceexample.dtos.requests.ItemUpForEligibility;
import com.ebay.shippingserviceexample.services.ItemEligibilityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ShippingEligibilityControllerTest {

    @InjectMocks ShippingEligibilityController subject;

    @Mock
    private ItemEligibilityService itemEligibilityService;

    @Test
    void checkItemEligibilityCallsService() {
        ItemUpForEligibility item = new ItemUpForEligibility();
        subject.checkItemEligibility(item);

        int expectedInvocations = 1;
        verify(itemEligibilityService, times(expectedInvocations)).checkItemEligibility(item);
    }
}