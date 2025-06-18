package org.skypro.skyshop.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.UUID;

public class FixPriceProduct extends Product {
    private static final int FIX_PRICE = 75;

    public FixPriceProduct(UUID id, String productName) {
        super(id , productName);
    }

    @Override
    public int getPrice() {
        return FIX_PRICE;
    }

    @Override
    public String toString() {
        String var10000 = this.getProductName();
        return "<" + var10000 + ">: <Фиксированная цена> <" + this.getPrice() + "> ";
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
