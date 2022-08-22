package com.example.pizzacloud.meal;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
@Data
public class Pizza {
    private Long id;
    @Column(name="CREATEDAT")
    private Date createdAt = new Date();
@NotNull
@Size(min = 4, message = "Name must be at least 4 characters long")
    private String name;
@NotNull
@Size (min = 1, message = "You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;
}
