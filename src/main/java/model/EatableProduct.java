package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EatableProduct extends Product {
    private double weight;

    public EatableProduct(double Price, String Name, double weight) {
        super(Price, Name);
        this.weight = weight;
    }
}
