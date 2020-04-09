package com.ebay.shippingserviceexample.services.admin;

import com.ebay.shippingserviceexample.daos.Category;
import com.ebay.shippingserviceexample.dtos.requests.UpdatedCategory;
import com.ebay.shippingserviceexample.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AdminCategoryServiceTest {

    @InjectMocks
    private AdminCategoryService subject;

    @Mock
    private CategoryRepository categoryRepository;

    @Test
    void updateCategoryShouldSaveWithUpdatedValues() {
        List<Integer> updatedValues = Arrays.asList(9, 16);
        List<Integer> currentValues = Arrays.asList(1, 4);
        Category currentCategory = new Category(currentValues, true);
        when(categoryRepository.findCurrentCategories()).thenReturn(currentCategory);

        UpdatedCategory updatedCategory = new UpdatedCategory(updatedValues);
        subject.updateCategory(updatedCategory);
        List<Integer> newValues = new ArrayList<>();
        newValues.addAll(currentValues);
        newValues.addAll(updatedValues);
        Category category = new Category(newValues, true);
        verify(categoryRepository, times(1)).insert(category);
    }

    @Test
    void updateCategoryShouldUpdatePreviousVersionWithFalse() {
        List<Integer> currentValues = Arrays.asList(1, 4);
        Category currentCategory = new Category(currentValues, true);
        when(categoryRepository.findCurrentCategories()).thenReturn(currentCategory);

        UpdatedCategory updatedCategory = new UpdatedCategory(Arrays.asList(1,2));
        subject.updateCategory(updatedCategory);

        currentCategory.setCurrent(false);
        verify(categoryRepository, times(1)).save(currentCategory);
    }
}