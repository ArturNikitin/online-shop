package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UneatableProduct extends Product {
    UneatableProduct(UneatableProductBuilder builder) {
        super(builder.getPrice(), builder.getName());
    }
}
