
package org.skypro.skyshop.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(UUID id, String productName, int price) {
        super(id, productName);
        if (price <= 0) {
            throw new IllegalArgumentException("цена должна быть строго больше 0");
        } else {
            this.price = price;
        }
    }
    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "<" + getProductName() + ">: <" + price + ">";
    }

    @Override
    public boolean isSpecial() {
        return false;
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
