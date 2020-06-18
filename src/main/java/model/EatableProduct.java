package model;

import lombok.Data;

@Data
public class EatableProduct extends Product {

    EatableProduct(EatableProductBuilder builder) {
        super(builder.getPrice(), builder.getName());
    }
}
