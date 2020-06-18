package repository;

import model.Product;

import java.util.HashMap;
import java.util.Map;

public class BasketRepositoryImpl implements BasketRepository {
    private Map<Product, Integer> basket = new HashMap<>();


    @Override
    public void addProduct(Product product) {
        basket.computeIfPresent(product, (k, v) -> ++v);
        basket.putIfAbsent(product, 1);
    }

    @Override
    public Map<Product, Integer> getAllBasket() {
        return basket;
    }

    @Override
    public void removeProduct(Product product) {
        basket.remove(product);
    }

    @Override
    public void emptyBasket() {
        basket = new HashMap<>();
    }
}
