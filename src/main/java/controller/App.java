package controller;

import model.EatableProduct;
import model.Product;
import model.UneatableProduct;
import repository.BasketRepository;
import repository.ProductRepository;
import repository.WarehouseRepository;
import repository.impl.*;
import service.Runner;
import service.RunnerBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    private static BasketRepository basketRepository = new BasketRepositoryConsoleImpl();
    private static ProductRepository<Product> productRepository = new ProductRepositoryJdbcImpl();
    private static WarehouseRepository warehouseRepository = new WarehouseRepositoryImpl();

    public static void main(String[] args) throws IOException {
        start();
    }


    public static void start() throws IOException {

        Runner runner = new RunnerBuilder()
                .basketRepository(basketRepository)
                .productRepository(productRepository)
                .warehouseRepository(warehouseRepository)
                .build();

        String response = null;
        System.out.println("=====================HELLO=====================");

        boolean exit = false;
        boolean emptyBasket = true;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (!exit) {
            System.out.println();
            System.out.println("Press 1 to get all products");
            System.out.println("Press 2 to add product to your basket");
            System.out.println("Press 3 to check your basket");
            if (!emptyBasket) {
                System.out.println("Press 4 to empty your basket");
                System.out.println("Press 5 to remove item from your basket");
            }
            System.out.println("Type \"exit\" to close the app");
            response = br.readLine();
            switch (response) {
                case ("1"):
                    runner.getAllProducts();
                    break;
                case ("2"):
                    runner.addProduct();
                    emptyBasket = false;
                    break;
                case ("3"):
                    runner.showBasket();
                    break;
                case ("4"):
                    if (!emptyBasket) {
                        System.out.println("incorrect command");
                    } else {
                        runner.empty();
                        emptyBasket = true;
                    }
                    break;
                case ("5"):
                    if (!emptyBasket) {
                        System.out.println("incorrect command");
                    } else {
                        runner.remove();
                        emptyBasket = true;
                    }
                    break;
                case ("exit"):
                    exit = true;
                    System.out.println("bye!");
                    break;
                default:
                    System.out.println("incorrect command");
            }
        }
        br.close();
    }
}
