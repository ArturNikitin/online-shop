package service.command;

import repository.BasketRepository;

public class Empty implements Command {
    private BasketRepository repository;

    public Empty(BasketRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        repository.emptyBasket();
    }
}
