package service.command;

import lombok.AllArgsConstructor;
import repository.BasketRepository;
import repository.WarehouseRepository;

@AllArgsConstructor
public class Empty implements Command {
    private BasketRepository basketRepository;
    private WarehouseRepository warehouseRepository;

    @Override
    public void execute() {
        basketRepository.getAllBasket().forEach((k, v) -> {
            warehouseRepository.updateStockValue(k, v);
        });
        basketRepository.emptyBasket();
    }
}
