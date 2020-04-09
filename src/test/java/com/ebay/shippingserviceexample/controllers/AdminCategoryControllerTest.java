package com.ebay.shippingserviceexample.controllers;

import com.ebay.shippingserviceexample.daos.Category;
import com.ebay.shippingserviceexample.daos.Price;
import com.ebay.shippingserviceexample.dtos.requests.UpdatedCategory;
import com.ebay.shippingserviceexample.dtos.requests.UpdatedPrice;
import com.ebay.shippingserviceexample.services.admin.AdminCategoryService;
import com.ebay.shippingserviceexample.services.admin.AdminPriceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class AdminCategoryControllerTest {
    @InjectMocks
    private AdminCategoryController subject;


    @Mock
    private AdminCategoryService adminCategoryService;


    @Test
    void updateCategoryShouldCallAdminCategoryService() {
        List<Integer> values = Arrays.asList(12, 15);
        UpdatedCategory updatedCategory = new UpdatedCategory(values);
        Category category = new Category(Arrays.asList(4, 6, 12), true);
        when(adminCategoryService.updateCategory(updatedCategory)).thenReturn(category);

        subject.updateCategory(updatedCategory);

        int expectedInvocations = 1;
        verify(adminCategoryService, times(expectedInvocations)).updateCategory(updatedCategory);
    }
}