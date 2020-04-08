package com.ebay.shippingserviceexample.services;

import com.ebay.shippingserviceexample.EligibleProductService;
import com.ebay.shippingserviceexample.dtos.requests.ItemUpForEligibility;
import com.ebay.shippingserviceexample.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ItemCategoryService implements EligibleProductService {

    private CategoryRepository categoryRepository;

    @Autowired
    public ItemCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean isEligible(ItemUpForEligibility itemUpForEligibility) {
        Set<Integer> itemCategories = categoryRepository.get();
        return itemCategories.contains(itemUpForEligibility.getCategory());
    }
}
