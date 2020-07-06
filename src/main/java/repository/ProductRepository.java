package repository;

import model.Product;

import java.util.Set;

public interface ProductRepository<T extends Product> {
    Set<T> getAllProducts();

    T getProductById(int id);
}
