package com.example.pizzacloud.meal;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data

@Document(collection="ingredients")
public class Ingredient {
    @Id
    public final String id;
    public final String name;
    public final Type type;


    public enum Type {
        SAUCE, SEAFOODS, VEGGIES, MEAT, BOARD,
    }
}
