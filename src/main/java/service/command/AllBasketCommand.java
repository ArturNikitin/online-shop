package service.command;

import lombok.AllArgsConstructor;
import model.Product;
import repository.BasketRepository;

import java.util.Map;

@AllArgsConstructor
public class AllBasketCommand implements Command {
    private BasketRepository repository;


    @Override
    public void execute() {
        Map<Product, Integer> basket = repository.getAllBasket();
        if (basket.isEmpty()) {
            System.out.println("Your basket is empty");
        } else {
            basket.forEach((k, v) -> {
                System.out.println(k.getName() + ". " + v + " pcs");
            });
            System.out.println("Sum of your items in the basket = " + calculateSum(basket) + "$");
        }
    }

    private double calculateSum(Map<Product, Integer> basket) {
        return basket.keySet().stream()
                .mapToDouble(Product::getPrice)
                .sum();

    }
}
