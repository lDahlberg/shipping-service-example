package com.ebay.shippingserviceexample.daos;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Seller {

    @Indexed
    private String name;
    private boolean isSellerEnrolled;

    public Seller(boolean isSellerEnrolled, String name) {
        this.isSellerEnrolled = isSellerEnrolled;
        this.name = name;
    }

    public boolean isSellerEnrolled() {
        return isSellerEnrolled;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "isSellerEnrolled=" + isSellerEnrolled +
                '}';
    }
}
