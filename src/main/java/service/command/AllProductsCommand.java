package service.command;

import lombok.AllArgsConstructor;
import repository.ProductRepository;

@AllArgsConstructor
public class AllProductsCommand implements Command {
    private ProductRepository repository;

    @Override
    public void execute() {
        repository.getAllProducts().forEach((k, v) -> {
            System.out.println("id = " + k + ". " + v.getName() + ", price = " + v.getPrice() + "$");
        });
    }
}
