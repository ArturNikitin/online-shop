package service.command;

import model.EatableProduct;
import model.Product;
import model.UneatableProduct;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import repository.BasketRepository;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AllBasketCommandTest {
    private BasketRepository basketRepository;
    private Product product1;
    private Product product2;
    private AllBasketCommand command;
    private Map<Product, Integer> products = new HashMap<>();

    @BeforeEach
    void setUp() {
        basketRepository = Mockito.mock(BasketRepository.class);
        product1 = new EatableProduct(10.20, "apple", 1.2);
        product2 = new UneatableProduct(20.30, "book");
        command = new AllBasketCommand(basketRepository);
        products.put(product1, 2);
        products.put(product2, 3);
    }

    @Test
    void executeEmptyTest() {
        Mockito.when(basketRepository.getAllBasket()).thenReturn(new HashMap<>());
        command.execute();
        Mockito.verify(basketRepository, Mockito.times(1)).getAllBasket();
    }

    @Test
    void executeTest() {
        Mockito.when(basketRepository.getAllBasket()).thenReturn(products);
        command.execute();
        Mockito.verify(basketRepository, Mockito.times(1)).getAllBasket();
    }

    @Test
    void calculateSumTest() {
        products.forEach((k, v) -> {
            System.out.println(k.getName() + " " + k.getPrice() + " " + v);
        });
        assertTrue(Math.abs(command.calculateSum(products) - 81.3) < .0001);

    }

    @Test
    void calculateWrongSumTest() {
        assertFalse(Math.abs(command.calculateSum(products) - 82.3) < .0001);
    }

}