package org.skypro.skyshop.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.UUID;

public class DiscountedProduct extends Product {
    private int basePrice;
    private int percentDiscount;

    public DiscountedProduct(UUID id , String productName, int basePrice, int percentDiscount) {
        super(id, productName);
        if (basePrice <= 0) {
            throw new IllegalArgumentException("цена должна быть строго больше 0");
        }
        if (percentDiscount < 0 || percentDiscount > 100) {
            throw new IllegalArgumentException("процент должен быть числом в диапазоне от 0 до 100 включительно");
        }

        this.basePrice = basePrice;
        this.percentDiscount = percentDiscount;
    }

    @Override
    public int getPrice() {
        return basePrice - basePrice * percentDiscount / 100;
    }

    @Override
    public String toString() {
        return "<" + getProductName() + ">: <" + getPrice() + "> (<" + percentDiscount + ">%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override @JsonIgnore
    public String getSearchName() {
        return getProductName();
    }

    @Override
    public String getStringRepresentation() {
        return super.getStringRepresentation();
    }
}