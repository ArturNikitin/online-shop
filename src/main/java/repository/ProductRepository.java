package repository;

import model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getAllProducts();

    Product addProduct(Product product);
}
