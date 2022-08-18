package order;

import meal.Pizza;
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

    private List<Pizza> pizza = new ArrayList<>();

    public void addPizza(Pizza pizza){
        this.pizza.add(pizza);
    }
}
