package com.example.pizzacloud.order;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<PizzaOrder, Long> {
    PizzaOrder save(PizzaOrder pizzaOrder);
}
