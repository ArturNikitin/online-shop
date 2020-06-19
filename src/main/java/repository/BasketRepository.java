package repository;

import model.Product;

import java.util.Map;

public interface BasketRepository {
    Product addProduct(Product product);

    Map<Product, Integer> getAllBasket();

    void removeProduct(Product product);

    void emptyBasket();
}
