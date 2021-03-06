package com.ebay.shippingserviceexample.repository;

import com.ebay.shippingserviceexample.daos.Seller;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends MongoRepository<Seller, String> {
    @Query("{'name' : ?0}")
    Seller findSellerByName(String sellerName);
}
