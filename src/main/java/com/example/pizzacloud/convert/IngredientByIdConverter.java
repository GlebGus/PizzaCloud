package com.example.pizzacloud.convert;

import com.example.pizzacloud.DAO.IngredientRepository;
import com.example.pizzacloud.meal.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    private IngredientRepository repository;

    public IngredientByIdConverter(IngredientRepository repository) {
        this.repository = repository;
    }
    @Override
    public Ingredient convert(String id) {
        return repository.findById(id).orElse(null);
    }
}
