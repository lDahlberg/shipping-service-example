package com.ebay.shippingserviceexample.services;

import com.ebay.shippingserviceexample.daos.Category;
import com.ebay.shippingserviceexample.dtos.requests.ItemUpForEligibility;
import com.ebay.shippingserviceexample.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @InjectMocks
    private ItemCategoryService subject;

    @Mock
    private CategoryRepository categoryRepository;

    private List<Integer> categories;

    @BeforeEach
    public void setup() {
        categories = new ArrayList<>();
        categories.add(6);
        categories.add(9);
        categories.add(42);
    }

    @Test
    void isEligibleReturnsTrueWhenItemCategoryIsInSet() {
        when(categoryRepository.findCurrentCategories()).thenReturn(new Category(categories, true));

        String TITLE = "Hitchhiker's Guide to the Galaxy";
        String SELLER_NAME = "Ebay";
        double PRICE = 5.99;
        int CATEGORY = 6;
        ItemUpForEligibility item = new ItemUpForEligibility(TITLE, SELLER_NAME,  CATEGORY, PRICE);
        boolean result = subject.isEligible(item);

        assertTrue(result, "Should return true when category is in program");
    }
}