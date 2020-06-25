package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UneatableProduct extends Product {
    public UneatableProduct(int id, double price, String name) {
        super(id, price, name);
    }

    public UneatableProduct(double price, String name) {
        super(price, name);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
