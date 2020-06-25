package service.command;

import lombok.AllArgsConstructor;
import model.Product;
import repository.BasketRepository;
import repository.ProductRepository;
import repository.WarehouseRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@AllArgsConstructor
public class Remove implements Command {
    private BasketRepository basketRepository;
    private WarehouseRepository warehouseRepository;
    private ProductRepository productRepository;

    @Override
    public void execute() {
        System.out.println("write the id of the product you want to remover from your basket");
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
            warehouseRepository.updateStockValue(product, basketRepository.getAllBasket().get(product));
            basketRepository.removeProduct(product);
            System.out.println("thanks");
        }
    }
}
