package com.example.pizzacloud.order;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.example.pizzacloud.meal.Pizza;
import com.example.pizzacloud.meal.PizzaUDT;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Table("orders")
public class PizzaOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @PrimaryKey
    private UUID id = Uuids.timeBased();
    private Date placedAt;
    @NotBlank(message = "Delivery name is required")
    private String deliveryName;
    @NotBlank(message = "Street is required")
    private String deliveryStreet;
    @NotBlank(message = "House is required")
    private String house;
    private String flat;
    private String entrance;
    private String floor;
    private String doorPhone;
    @CreditCardNumber(message = "Not a valid credit card number")
    private String ccNumber;
    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message="Must be formatted MM/YY")
    private String ccExpiration;
    @Digits(integer =3,fraction = 0,message = "Invalid CVV")
    private String ccCVV;
    @Column("pizza")
    private List<PizzaUDT> pizza = new ArrayList<>();

    public void addPizza(PizzaUDT pizza){
        this.pizza.add(pizza);
    }
}
