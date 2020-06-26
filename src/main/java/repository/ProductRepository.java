package repository;

import model.Product;

import java.util.Set;

public interface ProductRepository {
    Set<Product> getAllProducts();

    Product getProductById(int id);
}
