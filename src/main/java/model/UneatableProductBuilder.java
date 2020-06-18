package model;

import lombok.Getter;

@Getter
public class UneatableProductBuilder {
    private double price;
    private String name;

    public UneatableProductBuilder price(double price) {
        this.price = price;
        return this;
    }

    public UneatableProductBuilder name(String name) {
        this.name = name;
        return this;
    }

    public UneatableProduct build() {
        return new UneatableProduct(this);
    }
}
