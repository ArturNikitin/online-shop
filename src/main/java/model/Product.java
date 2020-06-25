package model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Product {
    private int id;
    private double price;
    private String name;

    public Product(double price, String name) {
        this.price = price;
        this.name = name;
    }
}
