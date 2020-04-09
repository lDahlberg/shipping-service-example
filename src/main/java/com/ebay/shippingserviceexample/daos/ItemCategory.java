package com.ebay.shippingserviceexample.daos;

import java.util.Set;

public final class ItemCategory {
    private final Set<Integer> categories;

    public ItemCategory(Set<Integer> categories) {
        this.categories = categories;
    }

    public Set<Integer> getCategories() {
        return categories;
    }
}
