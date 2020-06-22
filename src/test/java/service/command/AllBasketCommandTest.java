package service.command;

import model.EatableProductBuilder;
import model.Product;
import model.UneatableProductBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import repository.BasketRepository;

import java.util.HashMap;
import java.util.Map;

class AllBasketCommandTest {
    private BasketRepository basketRepository;
    private Product product1;
    private Product product2;
    private AllBasketCommand command;
    private Map<Product, Integer> products = new HashMap<>();

    @BeforeEach
    void setUp() {
        basketRepository = Mockito.mock(BasketRepository.class);
        product1 = new EatableProductBuilder().name("apple").price(10.20).build();
        product2 = new UneatableProductBuilder().name("book").price(20).build();
        command = new AllBasketCommand(basketRepository);
        products.put(product1, 2);
        products.put(product2, 3);
    }

    @Test
    void executeEmpty() {
        Mockito.when(basketRepository.getAllBasket()).thenReturn(new HashMap<>());
        command.execute();
        Mockito.verify(basketRepository, Mockito.times(1)).getAllBasket();
    }

    @Test
    void execute() {
        Mockito.when(basketRepository.getAllBasket()).thenReturn(products);
        command.execute();
        Mockito.verify(basketRepository, Mockito.times(1)).getAllBasket();
    }

    @Test
    void calculateSum() {
        Assertions.assertEquals(80.4,command.calculateSum(products));
    }

    @Test
    void calculateWrongSum() {
        Assertions.assertNotEquals(82.3,command.calculateSum(products));
    }

}