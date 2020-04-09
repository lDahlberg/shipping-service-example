package com.ebay.shippingserviceexample.services.admin;

import com.ebay.shippingserviceexample.daos.Price;
import com.ebay.shippingserviceexample.dtos.requests.UpdatedPrice;
import com.ebay.shippingserviceexample.repository.PriceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AdminPriceServiceTest {

    @InjectMocks
    private AdminPriceService subject;

    @Mock
    private PriceRepository priceRepository;

    @Test
    void updatePriceShouldCallRepository() {
        double value = 10.99;
        UpdatedPrice updatedPrice = new UpdatedPrice(value);
        Price price = new Price(9.99, true);
        when(priceRepository.findCurrentPrice()).thenReturn(price);

        subject.updatePrice(updatedPrice);

        int expectedInvocations = 1;
        Price priceToInsert = new Price(updatedPrice.getValue(), true);
        verify(priceRepository, times(expectedInvocations)).insert(priceToInsert);
    }

    @Test
    void updatePriceShouldUpdateCurrentPriceInDBToFalse() {
        double value = 10.99;
        UpdatedPrice updatedPrice = new UpdatedPrice(value);
        Price priceToReplace = new Price(updatedPrice.getValue(), true);
        when(priceRepository.findCurrentPrice()).thenReturn(priceToReplace);

        subject.updatePrice(updatedPrice);

        int expectedInvocations = 1;
        priceToReplace.setCurrent(false);
        verify(priceRepository, times(expectedInvocations)).save(priceToReplace);
    }
}