package repository;

import model.Product;

import java.util.Map;

public interface BasketRepository {
    void addProduct(Product product);

    Map<Product, Integer> getAllBasket();

    void removeProduct(Product product);

    void emptyBasket();
}
