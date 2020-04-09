package com.ebay.shippingserviceexample.controllers;

import com.ebay.shippingserviceexample.dtos.requests.ItemUpForEligibility;
import com.ebay.shippingserviceexample.dtos.responses.ItemEligibilityWrapper;
import com.ebay.shippingserviceexample.services.ItemEligibilityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ShippingEligibilityControllerTest {

    @InjectMocks ShippingEligibilityController subject;

    @Mock
    private ItemEligibilityService itemEligibilityService;
    private static final String SELLER = "John";
    private static final String TITLE = "Jacob";
    private static final int CATEGORY = 3;
    private static final double PRICE = 4.0;

    @Test
    void checkItemEligibilityCallsService() {
        ItemUpForEligibility item = new ItemUpForEligibility(TITLE, SELLER, CATEGORY, PRICE);
        subject.checkItemEligibility(item);
        int expectedInvocations = 1;
        verify(itemEligibilityService, times(expectedInvocations)).checkItemEligibility(item);
    }

    @Test
    void checkItemEligibilityReturnsCorrectResponseEntity() {
        ItemUpForEligibility item = new ItemUpForEligibility( TITLE, SELLER, CATEGORY, PRICE);
        when(itemEligibilityService.checkItemEligibility(item)).thenReturn(false);
        ResponseEntity<ItemEligibilityWrapper> result = subject.checkItemEligibility(item);

        assertAll("items match and eligibility is false",
                () -> assertEquals(Objects.requireNonNull(result.getBody()).getItem(), item),
                () -> assertFalse(Objects.requireNonNull(result.getBody()).isEligible()));
    }

    @Test
    void checkItemEligibilityReturnsBadRequestIfSellerIsMissing() {
        ItemUpForEligibility item = new ItemUpForEligibility(TITLE, null, CATEGORY, PRICE);
        ResponseEntity<ItemEligibilityWrapper> result = subject.checkItemEligibility(item);
        assertEquals(result.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    void checkItemEligibilityReturnsBadRequestIfCategoryIsMissing() {
        ItemUpForEligibility item = new ItemUpForEligibility( TITLE, SELLER, -1, PRICE);
        ResponseEntity<ItemEligibilityWrapper> result = subject.checkItemEligibility(item);
        assertEquals(result.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    void checkItemEligibilityReturnsBadRequestIfPriceIsMissing() {
        ItemUpForEligibility item = new ItemUpForEligibility( TITLE, SELLER, CATEGORY, -1.00);
        ResponseEntity<ItemEligibilityWrapper> result = subject.checkItemEligibility(item);
        assertEquals(result.getStatusCode(), HttpStatus.BAD_REQUEST);
    }
}