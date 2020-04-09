package com.ebay.shippingserviceexample.controllers;

import com.ebay.shippingserviceexample.daos.Price;
import com.ebay.shippingserviceexample.dtos.requests.UpdatedPrice;
import com.ebay.shippingserviceexample.services.admin.AdminPriceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AdminPriceControllerTest {

    @InjectMocks
    private AdminPriceController subject;

    @Mock
    private AdminPriceService adminPriceService;

    @Test
    void updatePriceShouldCallAdminPriceService() {
        double value = 10.99;
        UpdatedPrice updatedPrice = new UpdatedPrice(value);
        Price price = new Price(10, true);
        when(adminPriceService.updatePrice(updatedPrice)).thenReturn(price);

        subject.updatePrice(updatedPrice);

        int expectedInvocations = 1;
        verify(adminPriceService, times(expectedInvocations)).updatePrice(updatedPrice);
    }
}