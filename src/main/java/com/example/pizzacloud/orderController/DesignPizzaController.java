package com.example.pizzacloud.orderController;

import com.example.pizzacloud.DAO.IngredientRepository;
import lombok.extern.slf4j.Slf4j;
import com.example.pizzacloud.meal.Ingredient;
import com.example.pizzacloud.meal.Ingredient.Type;
import com.example.pizzacloud.meal.Pizza;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("pizzaOrder")
public class DesignPizzaController {
    private IngredientRepository repository;

    public DesignPizzaController(IngredientRepository repository) {
        this.repository = repository;
    }

    @ModelAttribute
    public void addIngredientToModel(Model model) {
        Iterable<Ingredient> ingredients = repository.findAll();
        List<Ingredient> result =
                StreamSupport.stream(ingredients.spliterator(), false)
                        .collect(Collectors.toList());
        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(result, type));
        }
    }

    @GetMapping
    public String showDesignForm(Model model) {
        model.addAttribute("pizza", new Pizza());
        return "design";
    }

    @PostMapping
    public String processPizza(@Valid @ModelAttribute("pizza") Pizza pizza, Errors errors) {
        if (errors.hasErrors()) {
            return "design";
        }
        //save the pizza
        log.info("Processing pizza: " + pizza);
        return "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByType(
            List<Ingredient> ingredients, Type type) {
        return ingredients.stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
