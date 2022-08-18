package com.example.pizzacloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class PizzaController {
    @GetMapping("/")
    public static String home(){
        return "home";
    }
}
