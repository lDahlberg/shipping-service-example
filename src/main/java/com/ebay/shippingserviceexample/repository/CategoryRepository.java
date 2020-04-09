package com.ebay.shippingserviceexample.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

public interface CategoryRepository extends MongoRepository<Set<Integer>, String> {
}
