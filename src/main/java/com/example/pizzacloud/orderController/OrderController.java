package com.example.pizzacloud.orderController;

import com.example.pizzacloud.order.PizzaOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {
    @GetMapping("/current")
    public String orderForm(Model model){
        model.addAttribute("pizzaOrder", new PizzaOrder());
        return "orderForm";
    }
    @PostMapping
    public String processOrder(PizzaOrder order){
        log.info("Order submitted: " + order);
        return "redirect:/";
    }
}
