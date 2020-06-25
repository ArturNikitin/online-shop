package repository;

import model.Product;

import java.util.Set;

public interface ProductRepository<T extends Product> {
    Set<T> getAllProducts();

    T addProduct(T product);

    T getProductById(int id);
}
