package model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public abstract class Product {
    private double Price;
    private String Name;
}
