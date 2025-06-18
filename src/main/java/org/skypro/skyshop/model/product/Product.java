package org.skypro.skyshop.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;
import java.util.Objects;
import java.util.UUID;

public abstract class Product implements Searchable{
    private final UUID id;
    private String productName;


    public Product(UUID id, String productName) {
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустой строкой или null");
        }
        this.id = id;
        this.productName = productName;

    }

    public UUID getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    @Override @JsonIgnore
    public String getSearchName() {
        return productName;
    }

    public abstract int getPrice();


    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", price=" + getPrice() +
                '}';
    }

    public abstract boolean isSpecial();

    @Override @JsonIgnore
    public String getSearchTerm() {
        return productName;
    }


    @Override @JsonIgnore
    public String getSearchType() {
        return "PRODUCT";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}