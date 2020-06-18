package service.command;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Runner {
    private Command getAllProducts;
    private Command getGetAllProductsFromBasket;
    private Command add;
    private Command remove;
    private Command empty;


    public void getAllProducts() {
        getAllProducts.execute();
    }

    public void showBasket() {
        getGetAllProductsFromBasket.execute();
    }

    public void addProduct() {
        add.execute();
    }

    public void remove() {
        remove.execute();
    }

    public void empty() {
        empty.execute();
    }
}
