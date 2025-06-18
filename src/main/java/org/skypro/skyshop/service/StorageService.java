package org.skypro.skyshop.service;

import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.springframework.stereotype.Service;
import org.skypro.skyshop.model.search.Searchable;

import java.util.*;

@Service
public class StorageService {

    private final Map<UUID, Product> products = new HashMap<>();
    private final Map<UUID, Article> articles = new HashMap<>();


    public StorageService() {
        init();
    }


    private void init() {
        Product cheese = new SimpleProduct(UUID.randomUUID(), "Cheese", 150);
        Product napkins = new FixPriceProduct(UUID.randomUUID(), "Napkins");
        Product dumplings = new DiscountedProduct(UUID.randomUUID(), "Dumplings", 300, 10);

        products.put(cheese.getId(), cheese);
        products.put(napkins.getId(), napkins);
        products.put(dumplings.getId(), dumplings);


        Article cheeseArticle = new Article(
                UUID.randomUUID(),
                "How to use cheese?",
                "eat"
        );
        Article dumplingsArticle = new Article(
                UUID.randomUUID(),
                "How to make dumplings ?",
                "you can boil or fry "
        );
        articles.put(cheeseArticle.getId(), cheeseArticle);
        articles.put(dumplingsArticle.getId(), dumplingsArticle);

    }

    public Collection<Product> getAllProducts() {
        return products.values();
    }

    public Collection<Article> getAllArticles() {
        return articles.values();
    }

    public Collection<Searchable> getAllSearchable() {
        List<Searchable> result = new ArrayList<>();
        result.addAll(products.values());
        result.addAll(articles.values());
        return result;
    }

}
