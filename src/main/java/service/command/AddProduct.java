package service.command;

import lombok.AllArgsConstructor;
import model.Product;
import repository.BasketRepository;
import repository.ProductRepository;
import repository.WarehouseRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@AllArgsConstructor
public class AddProduct implements Command {
    private ProductRepository productRepository;
    private BasketRepository basketRepository;
    private WarehouseRepository warehouseRepository;

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
            int stockValue = warehouseRepository.getStockValue(product);
            if (stockValue == 0) {
                System.out.println("We are sorry, but we are out of stock for this item");
            } else {
                basketRepository.addProduct(product);
                warehouseRepository.updateStockValue(product);
                System.out.printf("\nThanks, we added %s to your basket", product.getName());
            }
        }
    }
}
