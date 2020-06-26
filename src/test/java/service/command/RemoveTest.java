package service.command;

import model.EatableProduct;
import model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import repository.BasketRepository;
import repository.ProductRepository;
import repository.WarehouseRepository;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RemoveTest {
    private BasketRepository basketRepository;
    private WarehouseRepository warehouseRepository;
    private ProductRepository productRepository;
    private EatableProduct product;
    private Remove remove;
    private Map<Product, Integer> products;

    @BeforeEach
    void setUp() {
        basketRepository = Mockito.mock(BasketRepository.class);
        warehouseRepository = Mockito.mock(WarehouseRepository.class);
        productRepository = Mockito.mock(ProductRepository.class);
        product = new EatableProduct(2, 2.15, "orange", 0.5);
        remove = new Remove(basketRepository, warehouseRepository, productRepository);
        products = new HashMap<>();
        products.put(product, 2);
    }

    @Test
    void removeNotNullProduct() {
        Mockito.when(productRepository.getProductById(product.getId())).thenReturn(product);
        Mockito.when(basketRepository.getAllBasket()).thenReturn(products);
        remove.remove(2);
        Mockito.verify(productRepository, Mockito.times(1)).getProductById(product.getId());
        Mockito.verify(warehouseRepository, Mockito.times(1)).updateStockValue(product, 2);
        Mockito.verify(basketRepository, Mockito.times(1)).getAllBasket();
        Mockito.verify(basketRepository, Mockito.times(1)).removeProduct(product);
    }

    @Test
    void removeNullProduct() {
        Mockito.when(productRepository.getProductById(Mockito.anyInt())).thenReturn(null);
        remove.remove(1);
        Mockito.verify(productRepository, Mockito.times(1)).getProductById(1);
        Mockito.verify(warehouseRepository,
                Mockito.times(0)).updateStockValue(Mockito.any(), Mockito.anyInt());
        Mockito.verify(basketRepository, Mockito.times(0)).getAllBasket();
        Mockito.verify(basketRepository, Mockito.times(0)).removeProduct(Mockito.any());
    }
}