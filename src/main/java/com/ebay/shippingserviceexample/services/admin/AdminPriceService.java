package com.ebay.shippingserviceexample.services.admin;

import com.ebay.shippingserviceexample.daos.Price;
import com.ebay.shippingserviceexample.dtos.requests.UpdatedPrice;
import com.ebay.shippingserviceexample.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminPriceService {
    private PriceRepository priceRepository;

    @Autowired
    public AdminPriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public Price updatePrice(UpdatedPrice updatedPrice) {
        Price price = priceRepository.findCurrentPrice();
        if(price != null) {
            price.setCurrent(false);
            priceRepository.save(price);
        }
        Price newPrice = new Price(updatedPrice.getValue(), true);
        priceRepository.insert(newPrice);
        return newPrice;
    }
}
