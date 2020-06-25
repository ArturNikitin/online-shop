package service.command;

import repository.BasketRepository;
import repository.WarehouseRepository;

public class Empty implements Command {
    private BasketRepository basketRepository;
    private WarehouseRepository warehouseRepository;

    public Empty(BasketRepository basketRepository, WarehouseRepository warehouseRepository) {
        this.basketRepository = basketRepository;
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public void execute() {
        basketRepository.getAllBasket().forEach((k,v) -> {
            warehouseRepository.updateStockValue(k,v);
        });
        basketRepository.emptyBasket();
    }
}
