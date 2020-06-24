package model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Product {
    private double Price;
    private String Name;
}
