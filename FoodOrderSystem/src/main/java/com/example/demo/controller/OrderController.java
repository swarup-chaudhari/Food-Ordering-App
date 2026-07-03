package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Order;
import com.example.demo.service.OrderService;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Place Order (NO email in URL)
    @PostMapping("/place/{email}")
    public Order placeOrder(@PathVariable String email) {
        return orderService.placeOrder(email);
    }

    @GetMapping("/{email}")
    public List<Order> getOrders(@PathVariable String email) {
        return orderService.getOrdersByUser(email);
    }
    @PutMapping("/cancel/{id}")
    public Order cancelOrder(@PathVariable Long id) {
        return orderService.cancelOrder(id);
    }
}