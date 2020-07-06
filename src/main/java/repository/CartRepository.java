package repository;

import model.Cart;
import model.Product;
import model.User;

public interface CartRepository {
    Cart getCartByUser(User user);
    void addProduct(User user, Product product, int amount);
}
