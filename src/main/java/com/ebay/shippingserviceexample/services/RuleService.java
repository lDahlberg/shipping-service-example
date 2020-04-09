package com.ebay.shippingserviceexample.services;

import com.ebay.shippingserviceexample.EligibleProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/*This service is intended to extend to allow other rules to be added later. Currently it only contains the default
* until further clarity is gained concerning business needs*/
@Component
public class RuleService {

    public final List<EligibleProductService> defaultProducts;

    @Autowired
    public RuleService(SellerService sellerService, ItemCategoryService itemCategoryService, PriceService priceService) {
        this.defaultProducts = Arrays.asList(sellerService, itemCategoryService, priceService);
    }

    public List<EligibleProductService> getDefaultProducts() {
        return defaultProducts;
    }
}
