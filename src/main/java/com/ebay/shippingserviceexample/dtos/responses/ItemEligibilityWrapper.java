package com.ebay.shippingserviceexample.dtos.responses;

import com.ebay.shippingserviceexample.dtos.requests.ItemUpForEligibility;

public class ItemEligibilityWrapper {
    private boolean isEligible;
    private ItemUpForEligibility item;

    public ItemEligibilityWrapper(boolean isEligible, ItemUpForEligibility item) {
        this.isEligible = isEligible;
        this.item = item;
    }

    public boolean isEligible() {
        return isEligible;
    }

    public ItemUpForEligibility getItem() {
        return item;
    }
}
