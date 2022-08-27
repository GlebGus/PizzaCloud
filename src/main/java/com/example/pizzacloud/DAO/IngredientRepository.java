package com.example.pizzacloud.DAO;

import com.example.pizzacloud.meal.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
