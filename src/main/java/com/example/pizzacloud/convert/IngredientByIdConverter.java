package com.example.pizzacloud.convert;

import com.example.pizzacloud.meal.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    private Map<String, Ingredient> ingredientMap = new HashMap<>();

    public IngredientByIdConverter() {
        ingredientMap.put("FLTO", new Ingredient("FLTO", "Cheesy", Ingredient.Type.SAUCE));
        ingredientMap.put("COTO", new Ingredient("COTO", "Tomato", Ingredient.Type.SAUCE));
        ingredientMap.put("GRBF", new Ingredient("GRBF", "Semi-sweet", Ingredient.Type.SAUCE));
        ingredientMap.put("CARN", new Ingredient("CARN", "Garlic", Ingredient.Type.SAUCE));
        ingredientMap.put("TMTO", new Ingredient("TMTO", "Tomato", Ingredient.Type.VEGGIES));
        ingredientMap.put("LETC", new Ingredient("LETC", "Cucumber", Ingredient.Type.VEGGIES));
        ingredientMap.put("CHED", new Ingredient("CHED", "Pepper", Ingredient.Type.VEGGIES));
        ingredientMap.put("JACK", new Ingredient("JACK", "Cheesy", Ingredient.Type.BOARD));
        ingredientMap.put("SLSA", new Ingredient("SLSA", "Lush", Ingredient.Type.BOARD));
        ingredientMap.put("SRCR", new Ingredient("SRCR", "Chicken", Ingredient.Type.MEAT));
        ingredientMap.put("SLMN", new Ingredient("SLMN", "Salmon", Ingredient.Type.MEAT));
        ingredientMap.put("PRKP", new Ingredient("PRKP", "Pork", Ingredient.Type.MEAT));
        ingredientMap.put("CRBB", new Ingredient("CRBB", "Crab", Ingredient.Type.SEAFOODS));
        ingredientMap.put("OYST", new Ingredient("OYST", "Oyster", Ingredient.Type.SEAFOODS));
        ingredientMap.put("SHMP", new Ingredient("SHMP", "Shrimp", Ingredient.Type.SEAFOODS));
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientMap.get(id);
    }
}
