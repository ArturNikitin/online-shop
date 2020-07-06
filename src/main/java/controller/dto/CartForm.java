package controller.dto;

import lombok.Getter;
import lombok.Setter;
import model.Product;

import java.util.Map;

@Getter
@Setter
public class CartForm {
    private Map<Product, Integer> products;
}
