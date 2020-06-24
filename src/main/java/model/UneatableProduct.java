package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UneatableProduct extends Product {
    public UneatableProduct(double Price, String Name) {
        super(Price, Name);
    }
}
