package repository;

import model.Product;

import java.util.List;
import java.util.stream.Stream;

public interface ProductRepository {
    List<Product> getAllProducts();

    Product addProduct(Product product);
}
