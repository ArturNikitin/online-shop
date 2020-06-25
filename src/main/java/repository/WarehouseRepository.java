package repository;

import model.Product;

public interface WarehouseRepository {
    int getStockValue(Product product);
    void updateStockValue(Product product, int stockValue);
    void updateStockValue(Product product);
}
