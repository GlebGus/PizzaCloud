package meal;

import lombok.Data;

@Data
public class Ingredient {
    public final int id;
    public final String name;
    public final Type type;

    public enum Type {
        SAUCE, SIZE, VEGGIES, MEAT, BOARD
    }
}
