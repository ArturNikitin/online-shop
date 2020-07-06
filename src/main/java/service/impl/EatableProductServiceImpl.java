package service.impl;

import lombok.AllArgsConstructor;
import model.EatableProduct;
import repository.ProductRepository;
import repository.impl.EatableProductRepositoryJdbcImpl;
import service.ProductService;

import java.util.Set;

public class EatableProductServiceImpl implements ProductService {
    private ProductRepository<EatableProduct> eatableProductProductRepository = new EatableProductRepositoryJdbcImpl();

    @Override
    public Set<EatableProduct> getAllProducts() {
        return eatableProductProductRepository.getAllProducts();
    }
}
