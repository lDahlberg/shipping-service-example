package com.ebay.shippingserviceexample.repository;

import com.ebay.shippingserviceexample.daos.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
    @Query("{'current' : true}")
    Category findCurrentCategories();
}
