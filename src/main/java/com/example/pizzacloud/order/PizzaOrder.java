package com.example.pizzacloud.order;

import com.example.pizzacloud.meal.Pizza;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Document
public class PizzaOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
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
    private List<Pizza> pizza = new ArrayList<>();

    public void addPizza(Pizza pizza){
        this.pizza.add(pizza);
    }
}
