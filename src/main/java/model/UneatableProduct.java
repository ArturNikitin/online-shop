package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UneatableProduct extends Product {
    private UneatableProductType type;

    public UneatableProduct(int id, double price, String name, UneatableProductType type) {
        super(id, price, name);
        this.type = type;
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
