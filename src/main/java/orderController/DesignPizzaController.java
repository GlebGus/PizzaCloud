package orderController;

import lombok.extern.slf4j.Slf4j;
import meal.Ingredient;
import meal.Ingredient.Type;
import meal.Pizza;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignPizzaController {
    @ModelAttribute
            public void addIngredientToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Margherita", Type.VEGGIES),
                new Ingredient("COTO", "Marinara", Type.SAUCE),
                new Ingredient("GRBF", "Carbonara", Type.SEAFOODS),
                new Ingredient("CARN", "Frutti di Mare", Type.SEAFOODS),
                new Ingredient("TMTO", "Quattro Formaggi", Type.VEGGIES),
                new Ingredient("LETC", "Napoletana", Type.VEGGIES),
                new Ingredient("CHED", "Crudo", Type.SAUCE),
                new Ingredient("JACK", "Montanara", Type.SEAFOODS),
                new Ingredient("SLSA", "Emiliana", Type.SAUCE),
                new Ingredient("SRCR", "Romana", Type.SAUCE)
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
    private Iterable<Ingredient> filterByType(
            List<Ingredient> ingredients, Type type){
        return ingredients.stream()
                .filter(x-> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
