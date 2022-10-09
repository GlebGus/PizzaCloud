package com.example.pizzacloud.order;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OrderRepository extends CrudRepository<PizzaOrder, UUID> {

}
