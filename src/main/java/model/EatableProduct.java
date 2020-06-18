package model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class EatableProduct extends Product{

    EatableProduct(EatableProductBuilder builder) {
        super(builder.getPrice(), builder.getName());
    }
}
