package com.ebay.shippingserviceexample.repository;

import com.ebay.shippingserviceexample.daos.Price;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends MongoRepository<Price, String> {
    @Query("{'current' : true}")
    Price findCurrentPrice();
}
