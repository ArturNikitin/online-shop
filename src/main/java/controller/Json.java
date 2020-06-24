package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.EatableProduct;
import model.UneatableProduct;

import java.io.File;
import java.util.List;

public class Json {
    private static ObjectMapper objectMapper = getObjectMapper();
    private static File eatableProducts = new File("src/main/resources/eatableProducts.json");
    private static File uneatableProducts = new File("src/main/resources/uneatableProducts.json");

    public static ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper;
    }

    public static List<UneatableProduct> uneatableProductsFromJSON() {
        try {
            return Json.getObjectMapper()
                    .readValue(uneatableProducts, Json.getObjectMapper().getTypeFactory().constructCollectionType(List.class, UneatableProduct.class));
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public static List<EatableProduct> eatableProductsFromJSON() {
        try {
            return Json.getObjectMapper()
                    .readValue(eatableProducts, Json.getObjectMapper().getTypeFactory().constructCollectionType(List.class, EatableProduct.class));
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
