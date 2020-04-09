package com.ebay.shippingserviceexample.services.admin;

import com.ebay.shippingserviceexample.daos.Category;
import com.ebay.shippingserviceexample.dtos.requests.UpdatedCategory;
import com.ebay.shippingserviceexample.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminCategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public AdminCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category updateCategory(UpdatedCategory updatedCategory) {
        Category currentCategory = categoryRepository.findCurrentCategories();
        List<Integer> currentValues = currentCategory.getValues();
        currentCategory.setCurrent(false);

        categoryRepository.save(currentCategory);
        List<Integer> updatedValues = new ArrayList<>();
        updatedValues.addAll(currentValues);
        updatedValues.addAll(updatedCategory.getValues());

        Category category = new Category(updatedValues, true);
        categoryRepository.insert(category);
        return category;
    }
}
