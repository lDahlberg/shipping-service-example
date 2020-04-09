package com.ebay.shippingserviceexample.dtos.requests;

public class UpdatedPrice {
    private double value;

    public UpdatedPrice() {
    }

    public UpdatedPrice(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "UpdatedPrice{" +
                "value=" + value +
                '}';
    }
}
