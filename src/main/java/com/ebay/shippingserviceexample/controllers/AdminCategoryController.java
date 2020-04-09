package com.ebay.shippingserviceexample.controllers;

import com.ebay.shippingserviceexample.daos.Category;
import com.ebay.shippingserviceexample.dtos.requests.UpdatedCategory;
import com.ebay.shippingserviceexample.services.admin.AdminCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/admin/category")
public class AdminCategoryController {

    private AdminCategoryService adminCategoryService;

    @Autowired
    public AdminCategoryController(AdminCategoryService adminCategoryService) {
        this.adminCategoryService = adminCategoryService;
    }

    @PutMapping
    public ResponseEntity<Category> updateCategory(@RequestBody UpdatedCategory updatedCategory) {
        // Verify admin privileges

        adminCategoryService.updateCategory(updatedCategory);
        return ResponseEntity.ok(new Category(Arrays.asList(1,2), true));
    }
}
