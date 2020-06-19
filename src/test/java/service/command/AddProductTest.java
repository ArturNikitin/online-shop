package service.command;

import model.EatableProductBuilder;
import model.Product;
import model.UneatableProductBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import repository.BasketRepository;
import repository.ProductRepository;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class AddProductTest {
    private BasketRepository basketRepository;
    private ProductRepository productRepository;
    private Map<Product, Integer> basket = new HashMap<>();
    private Map<Integer, Product> products = new HashMap<>();
    private Product product1;
    private Product product2;
    private AddProduct addProduct;


    @BeforeEach
    void setUp() {
        basketRepository = Mockito.mock(BasketRepository.class);
        productRepository = Mockito.mock(ProductRepository.class);
        product1 = new EatableProductBuilder().name("apple").price(10.20).build();
        product2 = new UneatableProductBuilder().name("book").price(20.30).build();
        addProduct = new AddProduct(productRepository, basketRepository);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addCorrectProductTest() {
        Mockito.when(productRepository.getProductById(1)).thenReturn(product2);
        Mockito.when(basketRepository.addProduct(product2)).thenReturn(product2);

        addProduct.addProduct(1);

        Mockito.verify(productRepository, Mockito.times(1)).getProductById(Mockito.anyInt());
        Mockito.verify(basketRepository, Mockito.times(1)).addProduct(Mockito.any());
    }

    @Test
    void addNotExistedProductTest() {
        Mockito.when(productRepository.getProductById(1)).thenReturn(null);
        Mockito.when(basketRepository.addProduct(product2)).thenReturn(product2);

        addProduct.addProduct(1);

        Mockito.verify(productRepository, Mockito.times(1)).getProductById(Mockito.anyInt());
        Mockito.verify(basketRepository, Mockito.times(0)).addProduct(Mockito.any());
    }
}