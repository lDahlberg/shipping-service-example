package com.ebay.shippingserviceexample.repository;

import com.ebay.shippingserviceexample.daos.Seller;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends MongoRepository<Seller, String> {

}
