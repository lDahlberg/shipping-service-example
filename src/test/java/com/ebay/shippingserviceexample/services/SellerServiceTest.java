package com.ebay.shippingserviceexample.services;

import com.ebay.shippingserviceexample.dtos.requests.ItemUpForEligibility;
import com.ebay.shippingserviceexample.repository.SellerRepository;
import com.ebay.shippingserviceexample.daos.Seller;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SellerServiceTest {

    @InjectMocks
    private SellerService subject;
    @Mock
    private SellerRepository repository;

    private static final String SELLER_NAME = "Peter";
    private static final String TITLE = "The Pink Panther";
    private static final int CATEGORY = 1964;
    private static final double PRICE = 19.99;

    @Test
    void isEligibleReturnsTrueWhenSellerIsInProgram() {
        Seller seller = new Seller(true);

        when(repository.findById(SELLER_NAME)).thenReturn(Optional.of(seller));

        ItemUpForEligibility item = new ItemUpForEligibility(TITLE, SELLER_NAME,  CATEGORY, PRICE);
        boolean result = subject.isEligible(item);

        assertTrue(result, "Should return true when seller is in program");
    }

    @Test
    void isEligibleReturnsFaleWhenSellerIsNull() {
        when(repository.findById(SELLER_NAME)).thenReturn(Optional.empty());

        ItemUpForEligibility item = new ItemUpForEligibility(TITLE, SELLER_NAME,  CATEGORY, PRICE);
        boolean result = subject.isEligible(item);

        assertFalse(result, "Should return false when seller does not exist");
    }
}