package com.example.pizzacloud.order;

import com.example.pizzacloud.bind.IngredientRef;
import com.example.pizzacloud.meal.Ingredient;
import com.example.pizzacloud.meal.Pizza;
import net.bytebuddy.jar.asm.Type;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JdbcOrderRepository implements OrderRepository {
    private JdbcOperations jdbcOperations;

    public JdbcOrderRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    @Transactional
    public PizzaOrder save(PizzaOrder order) {
        PreparedStatementCreatorFactory psfc = new PreparedStatementCreatorFactory(
                "insert into PIZZA_ORDER"
                        + "(delivery_name, delivery_street,"
                        + " house, flat, entrance, floor, doorphone,"
                        + " cc_number, cc_expiration, cc_cvv, placed_at) "
                        + "values ( ?,?,?,?,?,?,?,?,?,?,? )",
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                Types.VARCHAR, Types.TIMESTAMP
        );
        psfc.setReturnGeneratedKeys(true);
        order.setPlacedAt(new Date());
        PreparedStatementCreator psc =
                psfc.newPreparedStatementCreator(
                        Arrays.asList(
                                order.getDeliveryName(),
                                order.getDeliveryStreet(),
                                order.getHouse(),
                                order.getFlat(),
                                order.getEntrance(),
                                order.getFloor(),
                                order.getDoorPhone(),
                                order.getCcNumber(),
                                order.getCcExpiration(),
                                order.getCcCVV(),
                                order.getPlacedAt()));

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(psc, keyHolder);
        long orderId = keyHolder.getKey().longValue();
        order.setId(orderId);
        List<Pizza> pizzaList = order.getPizza();
        int i = 0;
        for (Pizza pizza : pizzaList) {
            savePizza(orderId, i++, pizza);
        }
        return order;
    }

    private long savePizza(Long orderId, int orderKey, Pizza pizza) {
        pizza.setCreatedAt(new Date());
        PreparedStatementCreatorFactory pscf =
                new PreparedStatementCreatorFactory(
                        "insert into PIZZA"
                                + "(NAME, CREATED_AT, PIZZA_ORDER, PIZZA_ORDER_KEY)"
                                + "values ( ?,?,?,? )",
                        Types.VARCHAR, Types.TIMESTAMP, Type.LONG, Type.LONG);
        pscf.setReturnGeneratedKeys(true);
        PreparedStatementCreator psc = pscf.newPreparedStatementCreator(
                Arrays.asList(pizza.getName()
                        , pizza.getCreatedAt(),
                        orderId,
                        orderKey));
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(psc, keyHolder);
        long pizzaId = keyHolder.getKey().longValue();
        pizza.setId(pizzaId);
        List<IngredientRef> ingredientRefs = pizza.getIngredients().stream()
                .map(ing -> new IngredientRef(ing.getName()))
                .collect(Collectors.toList());
        saveIngredientRefs(pizzaId, ingredientRefs);
        return pizzaId;
    }

    private void saveIngredientRefs(long pizzaId, List<IngredientRef> ingredientRefs) {
        int key = 0;
        for (IngredientRef ingredientRef : ingredientRefs) {
            jdbcOperations.update(
                    "insert into Ingredient_Ref (ingredient, PIZZA, PIZZA_KEY) "
                            + "values (?, ?, ?)",
                    ingredientRef.getIngredient(), pizzaId, key++);
        }

    }
}
