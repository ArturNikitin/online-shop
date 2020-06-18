package service.command;

import model.Product;
import repository.BasketRepository;

import java.util.Map;

public class AllBasketCommand implements Command {
    private BasketRepository repository;

    public AllBasketCommand(BasketRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        Map<Product, Integer> basket = repository.getAllBasket();
        if (basket.isEmpty()) {
            System.out.println("Your basket is empty");
        } else {
            basket.forEach((k, v) -> {
                System.out.println(k.getName() + ". " + v + " pcs");
            });
        }
    }
}
