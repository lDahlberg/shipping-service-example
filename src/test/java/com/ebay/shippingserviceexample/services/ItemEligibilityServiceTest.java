package com.ebay.shippingserviceexample.services;

import com.ebay.shippingserviceexample.EligibleProductService;
import com.ebay.shippingserviceexample.dtos.requests.ItemUpForEligibility;
import daos.Seller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemEligibilityServiceTest {

    @InjectMocks
    private ItemEligibilityService subject;

    @Mock
    private RuleService ruleService;

    @Mock
    private SellerService sellerService;

    @Mock
    private ItemCategoryService itemCategoryService;

    private static final String SELLER_NAME = "Peter";
    private static final String TITLE = "The Pink Panther";
    private static final int CATEGORY = 1964;
    private static final double PRICE = 19.99;

    private List<EligibleProductService> DEFAULT_PRODUCTS;

    @BeforeEach
    public void setup(){
        DEFAULT_PRODUCTS = new ArrayList<>();
        DEFAULT_PRODUCTS.add(sellerService);
        DEFAULT_PRODUCTS.add(itemCategoryService);
    }

    @Test
    public void checkItemEligibilityRunsThroughServicesWhichReturnTrueAndReturnsTrue() {
        ItemUpForEligibility item = new ItemUpForEligibility(TITLE, SELLER_NAME,  CATEGORY, PRICE);

        when(ruleService.getDefaultProducts()).thenReturn(DEFAULT_PRODUCTS);
        when(sellerService.isEligible(item)).thenReturn(true);
        when(itemCategoryService.isEligible(item)).thenReturn(true);

        boolean result = subject.checkItemEligibility(item);

        assertTrue(result, "Item rules that pass returns true");
    }

    @Test
    public void runsThroughServicesAndChecksForEligibility() {
        ItemUpForEligibility item = new ItemUpForEligibility(TITLE, SELLER_NAME,  CATEGORY, PRICE);

        when(ruleService.getDefaultProducts()).thenReturn(DEFAULT_PRODUCTS);
        when(sellerService.isEligible(item)).thenReturn(true);
        when(itemCategoryService.isEligible(item)).thenReturn(false);

        boolean result = subject.checkItemEligibility(item);

        assertFalse(result, "Item with failing rule returns false");
    }
}