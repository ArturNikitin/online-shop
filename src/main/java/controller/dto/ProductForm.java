package controller.dto;

import lombok.Getter;
import lombok.Setter;
import model.EatableProduct;
import model.UneatableProduct;

import java.util.Set;

@Getter
@Setter
public class ProductForm {
    private Set<EatableProduct> eatableProducts;
    private Set<UneatableProduct> uneatableProducts;
}
