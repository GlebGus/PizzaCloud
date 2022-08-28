package com.example.pizzacloud.meal;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Ingredient {
    @Id
    public String id;
    public String name;
    public Type type;

    public Ingredient() {

    }


    public enum Type {
        SAUCE, SEAFOODS, VEGGIES, MEAT, BOARD,
    }
}
