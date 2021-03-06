package service;

import repository.BasketRepository;
import repository.ProductRepository;
import service.command.*;

public class RunnerBuilder {
    private BasketRepository basketRepository;
    private ProductRepository productRepository;

    public RunnerBuilder basketRepository(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
        return this;
    }

    public RunnerBuilder productRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
        return this;
    }

    public Runner build() {
        return new Runner(new AllProductsCommand(productRepository), new AllBasketCommand(basketRepository), new AddProduct(productRepository, basketRepository),
                new Remove(basketRepository, productRepository), new Empty(basketRepository));
    }
}
