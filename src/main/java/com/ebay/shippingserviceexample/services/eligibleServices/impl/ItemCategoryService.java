package com.ebay.shippingserviceexample.services.eligibleServices.impl;

import com.ebay.shippingserviceexample.daos.Category;
import com.ebay.shippingserviceexample.dtos.requests.ItemUpForEligibility;
import com.ebay.shippingserviceexample.repository.CategoryRepository;
import com.ebay.shippingserviceexample.services.eligibleServices.EligibleProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ItemCategoryService implements EligibleProductService {
    private final List<Integer> defaultCategoryValues = Arrays.asList(1, 4, 9);

    private CategoryRepository categoryRepository;

    @Autowired
    public ItemCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean isEligible(ItemUpForEligibility itemUpForEligibility) {
        // This should ideally be cached and only be changed during admin updates in the future
        Category category = categoryRepository.findCurrentCategories();
        Set<Integer> itemCategories;
        if(category != null && !category.getValues().isEmpty()) {
            itemCategories = new HashSet<>(category.getValues());
        } else {
            itemCategories = new HashSet<>(defaultCategoryValues);
        }
        return itemCategories.contains(itemUpForEligibility.getCategory());
    }
}
