package com.ebay.shippingserviceexample.daos;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public final class Category {
    private List<Integer> values;
    @Indexed
    private final boolean current;

    public Category(List<Integer> values, boolean current) {
        this.values = values;
        this.current = current;
    }

    public List<Integer> getValues() {
        return values;
    }

    public boolean isCurrent() {
        return current;
    }
}
