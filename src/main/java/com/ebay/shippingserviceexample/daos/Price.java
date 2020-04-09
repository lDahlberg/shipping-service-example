package com.ebay.shippingserviceexample.daos;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Price {
    private double value;
    private boolean current;

    public Price(double value, boolean current) {
        this.value = value;
        this.current = current;
    }

    public double getValue() {
        return value;
    }

    public boolean isCurrent() {
        return current;
    }
}
