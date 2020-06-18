package model;

import lombok.Getter;

@Getter
public class EatableProductBuilder {
    private double price;
    private String name;

    public EatableProductBuilder price(double price) {
        this.price = price;
        return this;
    }

    public EatableProductBuilder name(String name) {
        this.name = name;
        return this;
    }

    public EatableProduct build() {
        return new EatableProduct(this);
    }
}
