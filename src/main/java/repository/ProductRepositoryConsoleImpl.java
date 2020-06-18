package repository;

import model.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductRepositoryConsoleImpl implements ProductRepository {
    private Map<Integer, Product> products = new HashMap<>();
    private static int id = 1;

    @Override
    public Map<Integer, Product> getAllProducts() {
        return products;
    }

    @Override
    public Product addProduct(Product product) {
        products.put(id++, product);
        return product;
    }

    @Override
    public Product getProductById(int id) {
        return products.get(id);
    }
}
