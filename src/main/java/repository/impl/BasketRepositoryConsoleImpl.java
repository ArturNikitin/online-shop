package repository.impl;

import lombok.Getter;
import model.Product;
import repository.BasketRepository;

import java.util.HashMap;
import java.util.Map;

@Getter
public class BasketRepositoryConsoleImpl implements BasketRepository {
    private Map<Product, Integer> basket = new HashMap<>();


    @Override
    public Product addProduct(Product product) {
        basket.computeIfPresent(product, (k, v) -> ++v);
        basket.putIfAbsent(product, 1);
        return product;
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
