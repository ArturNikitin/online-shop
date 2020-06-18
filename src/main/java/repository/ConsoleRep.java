package repository;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsoleRep implements ProductRepository {
    private Map<String, Product> products = new HashMap<>();

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product addProduct(Product product) {
        products.put(product.getName(), product);
        return product;
    }
}
