package com.ebay.shippingserviceexample.dtos.requests;

import java.util.Objects;

// Note that I opted not to use Lombok for these classes to remove some boilerplate
public class ItemUpForEligibility {
    private String title;
    private String seller;
    private int category;
    private double price;

    public ItemUpForEligibility() {
    }

    public ItemUpForEligibility(String title, String seller, int category, double price) {
        this.title = title;
        this.seller = seller;
        this.category = category;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemUpForEligibility that = (ItemUpForEligibility) o;
        return category == that.category &&
                Double.compare(that.price, price) == 0 &&
                Objects.equals(title, that.title) &&
                Objects.equals(seller, that.seller);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, seller, category, price);
    }
}
