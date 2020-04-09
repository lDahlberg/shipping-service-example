package com.ebay.shippingserviceexample.dtos.requests;

import java.util.List;
import java.util.Objects;

public class UpdatedCategory {
    private List<Integer> values;

    public UpdatedCategory() {
    }

    public UpdatedCategory(List<Integer> value) {
        this.values = value;
    }

    public List<Integer> getValues() {
        return values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdatedCategory that = (UpdatedCategory) o;
        return Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }
}
