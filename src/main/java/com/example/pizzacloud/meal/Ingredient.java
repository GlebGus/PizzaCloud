package com.example.pizzacloud.meal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE,force = true)
@Table("ingridients")
public class Ingredient {
    @PrimaryKey
    public final String id;
    public final String name;
    public final Type type;


    public enum Type {
        SAUCE, SEAFOODS, VEGGIES, MEAT, BOARD,
    }
}
