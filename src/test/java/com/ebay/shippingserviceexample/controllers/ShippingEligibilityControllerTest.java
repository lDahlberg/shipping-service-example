package com.ebay.shippingserviceexample.controllers;

import com.ebay.shippingserviceexample.dtos.requests.ItemUpForEligibility;
import com.ebay.shippingserviceexample.dtos.responses.ItemEligibilityWrapper;
import com.ebay.shippingserviceexample.services.ItemEligibilityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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

    @Test
    void checkItemEligibilityReturnsCorrectResponseEntity() {
        ItemUpForEligibility item = new ItemUpForEligibility();
        when(itemEligibilityService.checkItemEligibility(item)).thenReturn(false);
        ResponseEntity<ItemEligibilityWrapper> result = subject.checkItemEligibility(item);

        assertAll("items match and eligibility is false",
                () -> assertEquals(Objects.requireNonNull(result.getBody()).getItem(), item),
                () -> assertFalse(Objects.requireNonNull(result.getBody()).isEligible()));
    }
}