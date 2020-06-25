package service.command;

import lombok.AllArgsConstructor;
import model.EatableProduct;
import model.Product;
import model.UneatableProduct;
import repository.ProductRepository;

@AllArgsConstructor
public class AllProductsCommand implements Command {
    private ProductRepository<EatableProduct> eatableProductRepository;
    private ProductRepository<UneatableProduct> uneatableProductRepository;
    private ProductRepository<Product> productRepository;

    public AllProductsCommand(ProductRepository<Product> productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void execute() {
        productRepository.getAllProducts().forEach(v ->{
            if (v instanceof EatableProduct) {
                if (((EatableProduct) v).getWeight() != 0d) {
                    System.out.printf("\nProduct: %s\nID: %d\nPrice: %.2f$\nWeight: %.2fkg\n", v.getName(), v.getId(), v.getPrice(), ((EatableProduct) v).getWeight());
                } else {
                    System.out.printf("\nProduct: %s\nID: %d\nPrice: %.2f$\n1 pcs\n", v.getName(), v.getId(), v.getPrice());
                }
            } else
                System.out.printf("\nProduct: %s\nID: %d\nPrice: %.2f$\n1 pcs\n", v.getName(), v.getId(), v.getPrice());
        });

        /*eatableProductRepository.getAllProducts().forEach(v -> {

        });
        uneatableProductRepository.getAllProducts().forEach(v -> {
            System.out.printf("\nProduct: %s\nID: %d\nPrice: %.2f$\n1 pcs\n", v.getName(), v.getId(), v.getPrice());
        });*/
    }
}
