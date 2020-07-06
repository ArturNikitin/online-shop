package service.impl;

import model.*;
import repository.CartRepository;
import repository.ProductRepository;
import repository.UserRepository;
import repository.impl.CartRepositoryJdbcImpl;
import repository.impl.EatableProductRepositoryJdbcImpl;
import repository.impl.UneatableProductRepositoryJdbcImpl;
import repository.impl.UserRepositoryJdbcImpl;
import service.CartService;

import java.util.HashMap;
import java.util.Map;

public class CartServiceImpl implements CartService {
    private CartRepository cartRepository = new CartRepositoryJdbcImpl();
    private UserRepository userRepository = new UserRepositoryJdbcImpl();
    private ProductRepository<EatableProduct> eatableProductRepository = new EatableProductRepositoryJdbcImpl();
    private ProductRepository<UneatableProduct> uneatableProductProductRepository = new UneatableProductRepositoryJdbcImpl();


    @Override
    public void addProduct(String userName, int productId, int amount) {
        User user = userRepository.getUserByName(userName);
        Product product = eatableProductRepository.getProductById(productId);
        if (product == null) {
            product = uneatableProductProductRepository.getProductById(productId);
        }
        if (user != null && product != null) {
            cartRepository.addProduct(user, product, amount);
        }
    }

    @Override
    public Map<Product, Integer> getCartByUser(String userName) {
        Map<Product, Integer> products = new HashMap<>();
        User user = userRepository.getUserByName(userName);
        Cart cart = null;
        if (user != null) {
            cart = cartRepository.getCartByUser(user);
        }
        if (cart == null) {
            return null;
        }
        Map<Integer, Integer> productsById = cart.getProducts();
        productsById.forEach((k,v) ->{
            Product product = eatableProductRepository.getProductById(k);
            if (product == null) {
                product = uneatableProductProductRepository.getProductById(k);
            }
            if (product != null) {
                products.put(product, k);
            }
        });
        return products;
    }
}
