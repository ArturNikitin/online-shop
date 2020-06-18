package repository;

import model.Product;

import java.util.Map;

public interface ProductRepository {
    Map<Integer, Product> getAllProducts();

    Product addProduct(Product product);

    Product getProductById(int id);
}
