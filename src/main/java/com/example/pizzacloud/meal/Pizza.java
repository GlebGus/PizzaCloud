package com.example.pizzacloud.meal;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
@Data
public class Pizza {
@NotNull
@Size(min = 2, message = "Name must be at least 2 characters long")
    private String name;
@NotNull
@Size (min = 1, message = "You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;
}
