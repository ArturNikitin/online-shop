package service;

import model.Cart;
import model.Product;

import java.util.Map;

public interface CartService {
    void addProduct(String userName, int productId, int amount);
    Map<Product, Integer> getCartByUser(String userName);
}
