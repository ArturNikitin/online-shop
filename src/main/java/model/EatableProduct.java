package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EatableProduct extends Product {
    private double weight;

    public EatableProduct(int id, double price, String name, double weight) {
        super(id, price, name);
        this.weight = weight;
    }

    public EatableProduct(double price, String name, double weight) {
        super(price, name);
        this.weight = weight;
    }
}
