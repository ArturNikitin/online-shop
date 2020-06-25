package service;

import repository.BasketRepository;
import repository.ProductRepository;
import repository.WarehouseRepository;
import service.command.*;

public class RunnerBuilder {
    private BasketRepository basketRepository;
    private ProductRepository productRepository;
    private WarehouseRepository warehouseRepository;

    public RunnerBuilder basketRepository(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
        return this;
    }

    public RunnerBuilder productRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
        return this;
    }

    public RunnerBuilder warehouseRepository(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
        return this;
    }

    public Runner build() {
        return new Runner(new AllProductsCommand(productRepository), new AllBasketCommand(basketRepository),
                new AddProduct(productRepository, basketRepository, warehouseRepository),
                new Remove(basketRepository, warehouseRepository, productRepository), new Empty(basketRepository, warehouseRepository));
    }
}
