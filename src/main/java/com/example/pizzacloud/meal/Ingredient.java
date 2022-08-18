package com.example.pizzacloud.meal;

import lombok.Data;

@Data
public class Ingredient {
    public final String id;
    public final String name;
    public final Type type;


    public enum Type {
        SAUCE, SEAFOODS, VEGGIES, MEAT, BOARD,
    }
}
