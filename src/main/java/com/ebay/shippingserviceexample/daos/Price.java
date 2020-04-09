package com.ebay.shippingserviceexample.daos;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Price {
    @Id
    private ObjectId id;
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

    public void setCurrent(boolean current) {
        this.current = current;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Double.compare(price.value, value) == 0 &&
                current == price.current;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, current);
    }

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", value=" + value +
                ", current=" + current +
                '}';
    }
}
