package com.example.pizzacloud.orderController;

import lombok.extern.slf4j.Slf4j;
import com.example.pizzacloud.meal.Ingredient;
import com.example.pizzacloud.meal.Ingredient.Type;
import com.example.pizzacloud.meal.Pizza;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignPizzaController {
    @ModelAttribute
            public void addIngredientToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Cheesy", Type.SAUCE ),
                new Ingredient("COTO", "Tomato", Type.SAUCE),
                new Ingredient("GRBF", "Semi-sweet", Type.SAUCE),
                new Ingredient("CARN", "Garlic", Type.SAUCE),
                new Ingredient("TMTO", "Tomato", Type.VEGGIES),
                new Ingredient("LETC", "Cucumber", Type.VEGGIES),
                new Ingredient("CHED", "Pepper", Type.VEGGIES),
                new Ingredient("JACK", "Cheesy", Type.BOARD),
                new Ingredient("SLSA", "Lush", Type.BOARD),
                new Ingredient("SRCR", "Chicken", Type.MEAT),
                new Ingredient("SLMN", "Salmon", Type.MEAT),
                new Ingredient("PRKP", "Pork", Type.MEAT),
                new Ingredient("CRBB", "Crab", Type.SEAFOODS),
                new Ingredient("OYST", "Oyster", Type.SEAFOODS),
                new Ingredient("SHMP", "Shrimp", Type.SEAFOODS)

        );
Type[] types = Ingredient.Type.values();
for(Type type: types){
    model.addAttribute(type.toString().toLowerCase(),
            filterByType(ingredients,type));
}
    }
    @GetMapping
    public String showDesignForm (Model model){
        model.addAttribute("pizza", new Pizza());
        return "design";
    }
    @PostMapping
    public String processPizza(Pizza pizza){
        //save the pizza
        log.info("Processing pizza: " + pizza);
        return "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByType(
            List<Ingredient> ingredients, Type type){
        return ingredients.stream()
                .filter(x-> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
