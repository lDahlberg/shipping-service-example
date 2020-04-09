package com.ebay.shippingserviceexample.daos;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document
public final class Category {
    @Id
    private ObjectId id;
    private List<Integer> values;
    @Indexed
    private boolean current;

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

    public void setCurrent(boolean isCurrent) {
        this.current = isCurrent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return current == category.current &&
                Objects.equals(values, category.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values, current);
    }
}
