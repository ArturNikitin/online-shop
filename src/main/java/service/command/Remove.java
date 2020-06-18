package service.command;

import model.Product;
import repository.BasketRepository;
import repository.ProductRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Remove implements Command {
    private BasketRepository basketRepository;
    private ProductRepository productRepository;

    public Remove(BasketRepository repository, ProductRepository productRepository) {
        this.basketRepository = repository;
        this.productRepository = productRepository;
    }

    @Override
    public void execute() {
        System.out.println("write the id of the product you want to remover from you basket");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int id = 0;
        try {
            id = Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Product product = productRepository.getProductById(id);
        if (product == null) {
            System.out.println("This product doesn't exist" +
                    "\nPlease enter valid product id");
        } else {
            basketRepository.removeProduct(product);
            System.out.println("thanks");
        }
    }
}
