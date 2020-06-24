package controller;

import repository.BasketRepository;
import repository.ProductRepository;
import repository.impl.BasketRepositoryImpl;
import repository.impl.ProductRepositoryConsoleImpl;
import service.Runner;
import service.RunnerBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    private static ProductRepository productRepository;
    private static BasketRepository basketRepository;


    public static void main(String[] args) throws IOException {
        productRepository = new ProductRepositoryConsoleImpl();
        basketRepository = new BasketRepositoryImpl();

        loadData();

        start();
    }

    public static void loadData() {
        Json.eatableProductsFromJSON().forEach(productRepository::addProduct);
        Json.uneatableProductsFromJSON().forEach(productRepository::addProduct);
    }

    public static void start() throws IOException {

        Runner runner = new RunnerBuilder()
                .basketRepository(basketRepository)
                .productRepository(productRepository)
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
                    runner.empty();
                    emptyBasket = true;
                    break;
                case ("5"):
                    runner.remove();
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
