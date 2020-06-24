package repository.impl;

import model.EatableProduct;
import model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductRepositoryConsoleImplTest {
    private ProductRepositoryConsoleImpl repository;
    private Product product1;
    private Product product2;

    @BeforeEach
    void setUp() {
        product1 = new EatableProduct(10.20, "apple", 1.2);
        product1 = new EatableProduct(20.30, "orange", 1.2);
        repository = new ProductRepositoryConsoleImpl();
    }

    @Test
    void addProduct() {
        repository.addProduct(product1);
        repository.addProduct(product2);
        assertEquals(product1, repository.getProducts().get(1));
        assertEquals(product2, repository.getProducts().get(2));
    }

    @Test
    void getProductById() {
        repository.getProducts().put(1, product1);
        Product product = repository.getProductById(1);
        assertEquals(product1, product);
    }
}