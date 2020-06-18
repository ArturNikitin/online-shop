package view;

import model.*;
import repository.ConsoleRep;
import repository.ProductRepository;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ProductRepository productRepository = new ConsoleRep();

        Product product = new EatableProductBuilder()
                .name("orange")
                .price(1.22)
                .build();

        Product product1 = new UneatableProductBuilder()
                .name("car")
                .price(10000)
                .build();

        productRepository.addProduct(product);
        productRepository.addProduct(product1);


        List<Product> products = productRepository.getAllProducts();
        products.forEach(x -> {
            System.out.println(x.getName() + " " + x.getPrice());
        });

    }
}
