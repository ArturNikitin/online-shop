package service.command;

import model.EatableProduct;
import model.Product;
import model.UneatableProduct;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import repository.BasketRepository;
import repository.ProductRepository;
import repository.WarehouseRepository;

class AddProductTest {
    private BasketRepository basketRepository;
    private ProductRepository productRepository;
    private WarehouseRepository warehouseRepository;
    private Product product1;
    private Product product2;
    private AddProduct addProduct;


    @BeforeEach
    void setUp() {
        basketRepository = Mockito.mock(BasketRepository.class);
        productRepository = Mockito.mock(ProductRepository.class);
        warehouseRepository = Mockito.mock(WarehouseRepository.class);
        product1 = new EatableProduct(10.20, "apple", 1.2);
        product2 = new UneatableProduct(20.30, "book");
        addProduct = new AddProduct(productRepository, basketRepository, warehouseRepository);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addCorrectProductTest() {
        Mockito.when(productRepository.getProductById(1)).thenReturn(product2);
        Mockito.when(basketRepository.addProduct(product2)).thenReturn(product2);
        Mockito.when(warehouseRepository.getStockValue(product2)).thenReturn(1);

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