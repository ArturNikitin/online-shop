package model;

import lombok.Data;

@Data
public class UneatableProduct extends Product {
    UneatableProduct(UneatableProductBuilder builder) {
        super(builder.getPrice(), builder.getName());
    }
}
