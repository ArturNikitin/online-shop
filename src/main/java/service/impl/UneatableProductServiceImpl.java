package service.impl;

import model.UneatableProduct;
import repository.ProductRepository;
import repository.impl.UneatableProductRepositoryJdbcImpl;
import service.ProductService;

import java.util.Set;


public class UneatableProductServiceImpl implements ProductService {
    private ProductRepository<UneatableProduct> productRepository = new UneatableProductRepositoryJdbcImpl();

    @Override
    public Set<UneatableProduct> getAllProducts() {
        return productRepository.getAllProducts();
    }
}
