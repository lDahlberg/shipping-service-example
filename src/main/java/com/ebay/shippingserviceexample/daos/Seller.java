package com.ebay.shippingserviceexample.daos;

public class Seller {
    private boolean isSellerEnrolled;

    public Seller(boolean isSellerEnrolled) {
        this.isSellerEnrolled = isSellerEnrolled;
    }

    public boolean isSellerEnrolled() {
        return isSellerEnrolled;
    }

    public static final Seller NULL = new Seller(false);

    @Override
    public String toString() {
        return "Seller{" +
                "isSellerEnrolled=" + isSellerEnrolled +
                '}';
    }
}
