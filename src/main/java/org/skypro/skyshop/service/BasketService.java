package org.skypro.skyshop.service;

import org.skypro.skyshop.exception.NoSuchProductException;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.view.BasketItem;
import org.skypro.skyshop.view.UserBasket;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BasketService {


    private final ProductBasket productBasket;
    private final StorageService storageService;


    public BasketService(ProductBasket productBasket, StorageService storageService) {
        this.productBasket = productBasket;
        this.storageService = storageService;
    }


    public void addProductToBasket(UUID id) {
        Optional<Product> productOpt = storageService.getProductById(id);

        if (productOpt.isPresent() == false) {
            throw new NoSuchProductException("Product with this ID not found: " + id); // ⬅ если уже заменили исключение
        }

        productBasket.addProduct(id);
    }

    public UserBasket getUserBasket() {
        Map<UUID, Integer> raw = productBasket.getAllProducts();

        List<BasketItem> items = raw.entrySet().stream()
                .map(entry -> {
                    Product product = storageService.getProductById(entry.getKey())
                            .orElseThrow(() -> new NoSuchProductException("Product with this ID not found: " + entry.getKey()));
                    return new BasketItem(product, entry.getValue());
                })
                .collect(Collectors.toList());

        return new UserBasket(items);
    }

}