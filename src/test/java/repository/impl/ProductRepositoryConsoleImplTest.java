package repository.impl;

import model.EatableProductBuilder;
import model.Product;
import model.UneatableProductBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.ProductRepository;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryConsoleImplTest {
    private ProductRepositoryConsoleImpl repository;
    private Product product1;
    private Product product2;

    @BeforeEach
    void setUp() {
        product1 = new EatableProductBuilder().name("apple").price(10.20).build();
        product2 = new UneatableProductBuilder().name("book").price(20.30).build();
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