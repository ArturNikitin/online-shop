package repository.impl;

import model.EatableProductBuilder;
import model.Product;
import model.UneatableProductBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.BasketRepository;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BasketRepositoryImplTest {
    private BasketRepositoryImpl basketRepository;
    private Product product1;
    private Product product2;

    @BeforeEach
    void setUp() {
        basketRepository = new BasketRepositoryImpl();
        product1 = new EatableProductBuilder().name("apple").price(10.20).build();
        product2 = new UneatableProductBuilder().name("book").price(20.30).build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addProductTest() {
        basketRepository.addProduct(product1);
        assertFalse(basketRepository.getBasket().isEmpty());
        assertNotNull(basketRepository.getBasket().get(product1));
        assertEquals(basketRepository.getBasket().get(product1), 1);
    }

    @Test
    void addSecondProductTest() {
        basketRepository.addProduct(product1);
        basketRepository.addProduct(product1);
        assertFalse(basketRepository.getBasket().isEmpty());
        assertNotNull(basketRepository.getBasket().get(product1));
        assertEquals(basketRepository.getBasket().get(product1), 2);
    }



    @Test
    void getAllBasket() {
        basketRepository.getBasket().put(product1,2);
        basketRepository.getBasket().put(product2,2);
        Map<Product, Integer> basket = basketRepository.getAllBasket();
        assertNotNull(basket);
        assertEquals(basket.get(product1), 2);
        assertEquals(basket.get(product2), 2);
    }

    @Test
    void removeProduct() {
        basketRepository.getBasket().put(product1,2);
        basketRepository.getBasket().put(product2,2);
        basketRepository.removeProduct(product1);
        Map<Product, Integer> basket = basketRepository.getBasket();
        assertNotNull(basket);
        assertNull(basket.get(product1));
        assertEquals(basket.get(product2), 2);
    }

    @Test
    void emptyBasket() {
        basketRepository.getBasket().put(product1,2);
        basketRepository.getBasket().put(product2,2);
        basketRepository.emptyBasket();
        Map<Product, Integer> basket = basketRepository.getBasket();
        assertTrue(basket.isEmpty());
    }
}