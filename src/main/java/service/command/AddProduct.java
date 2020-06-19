package service.command;

import model.Product;
import repository.BasketRepository;
import repository.ProductRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AddProduct implements Command {
    private ProductRepository productRepository;
    private BasketRepository basketRepository;

    public AddProduct(ProductRepository productRepository, BasketRepository basketRepository) {
        this.productRepository = productRepository;
        this.basketRepository = basketRepository;
    }

    @Override
    public void execute() {
        System.out.println("write the id of the product you want to add");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int id = 0;
        try {
            id = Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
        addProduct(id);
    }

    public void addProduct(int id) {
        Product product = productRepository.getProductById(id);
        if (product == null) {
            System.out.println("This product doesn't exist" +
                    "\nPlease enter valid product id");
        } else {
            basketRepository.addProduct(product);
            System.out.println("thanks");
        }
    }
}
