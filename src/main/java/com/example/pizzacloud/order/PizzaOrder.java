package com.example.pizzacloud.order;

import com.example.pizzacloud.meal.Pizza;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PizzaOrder {
    private String deliveryName;
    private String deliveryStreet;
    private String house;
    private String flat;
    private String entrance;
    private String floor;
    private String doorPhone;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;
    private List<Pizza> pizza = new ArrayList<>();

    public void addPizza(Pizza pizza){
        this.pizza.add(pizza);
    }
}
