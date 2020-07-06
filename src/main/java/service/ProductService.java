package service;

import model.Product;

import java.util.Set;

public interface ProductService {
    Set<? extends Product> getAllProducts();
}
