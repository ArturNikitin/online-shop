package service.command;

import lombok.AllArgsConstructor;
import model.EatableProduct;
import model.UneatableProduct;
import repository.ProductRepository;

@AllArgsConstructor
public class AllProductsCommand implements Command {
    private ProductRepository productRepository;

    @Override
    public void execute() {
        productRepository.getAllProducts().forEach(v -> {
            if (v instanceof EatableProduct) {
                if (((EatableProduct) v).getWeight() != 0d) {
                    System.out.printf("\nProduct: %s\nID: %d\nPrice: %.2f$\nWeight: %.2fkg\n", v.getName(), v.getId(), v.getPrice(), ((EatableProduct) v).getWeight());
                } else {
                    System.out.printf("\nProduct: %s\nID: %d\nPrice: %.2f$\n1 pcs\n", v.getName(), v.getId(), v.getPrice());
                }
            } else
                System.out.printf("\nProduct: %s\nID: %d\nPrice: %.2f$\n1 pcs\nType:%s\n", v.getName(), v.getId(), v.getPrice(), ((UneatableProduct) v).getType());
        });

    }
}
