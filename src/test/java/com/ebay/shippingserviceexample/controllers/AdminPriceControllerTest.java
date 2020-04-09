package com.ebay.shippingserviceexample.controllers;

import com.ebay.shippingserviceexample.daos.Price;
import com.ebay.shippingserviceexample.dtos.requests.UpdatedPrice;
import com.ebay.shippingserviceexample.services.admin.AdminPriceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AdminPriceControllerTest {

    @InjectMocks
    private AdminPriceController subject;

    @Mock
    private AdminPriceService adminPriceService;

    @Test
    public void updatePriceShouldCallAdminPriceService() {
        double value = 10.99;
        UpdatedPrice updatedPrice = new UpdatedPrice(value);
        Price price = new Price(10, true);
        when(adminPriceService.updatePrice(updatedPrice)).thenReturn(price);

        subject.updatePrice(updatedPrice);

        int expectedInvocations = 1;
        verify(adminPriceService, times(expectedInvocations)).updatePrice(updatedPrice);
    }

    @Test
    public void updatePriceShouldReturnBadRequestWhenNoValueExists() {
        UpdatedPrice updatedPrice = new UpdatedPrice(-1.00);

        ResponseEntity<Price> result = subject.updatePrice(updatedPrice);

        assertEquals(result.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    public void updatePriceShouldReturnUnauthorizedWhenNotAdmin() {
        UpdatedPrice updatedPrice = new UpdatedPrice(-1.00);

        ResponseEntity<Price> result = subject.updatePrice(updatedPrice);

        assertEquals(result.getStatusCode(), HttpStatus.BAD_REQUEST);
    }
}