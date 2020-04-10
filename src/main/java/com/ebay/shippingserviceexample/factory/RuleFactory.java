package com.ebay.shippingserviceexample.factory;

import com.ebay.shippingserviceexample.services.eligibleServices.EligibleProductService;
import com.ebay.shippingserviceexample.services.eligibleServices.impl.ItemCategoryService;
import com.ebay.shippingserviceexample.services.eligibleServices.impl.PriceService;
import com.ebay.shippingserviceexample.services.eligibleServices.impl.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/*This factory is intended to extend to allow other rules to be added later. Currently it only contains the default
* until further clarity is gained concerning business needs*/
@Component
public class RuleFactory {

    public final List<EligibleProductService> defaultProducts;

    @Autowired
    public RuleFactory(SellerService sellerService, ItemCategoryService itemCategoryService, PriceService priceService) {
        this.defaultProducts = Arrays.asList(sellerService, itemCategoryService, priceService);
    }

    public List<EligibleProductService> getDefaultProducts() {
        return defaultProducts;
    }
}
