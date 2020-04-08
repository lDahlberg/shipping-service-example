package com.ebay.shippingserviceexample.repository;

import daos.Seller;

public interface SellerRepository {
    Seller get(String sellerName);
}
