package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Cart;
import com.example.demo.entities.Order;
import com.example.demo.entities.OrderItems;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public Order placeOrder(String email) {

        List<Cart> cartItems = cartRepository.findByUserEmail(email);

        if (cartItems.isEmpty()) {
            throw new RuntimeException("Cart is Empty");
        }

        double total = 0;
        for (Cart item : cartItems) {
            total += item.getPrice() * item.getQuantity();
        }

        // Create Order
        Order order = new Order();
        order.setUserEmail(email);
        order.setTotalAmount(total);
        order.setStatus("PLACED");
        order.setOrderTime(LocalDateTime.now());

        // Convert Cart → OrderItems
        List<OrderItems> orderItems = cartItems.stream().map(item -> {
            OrderItems oi = new OrderItems();
            oi.setFoodId(item.getFoodId());
            oi.setFoodName(item.getFoodName());
            oi.setPrice(item.getPrice());
            oi.setQuantity(item.getQuantity());
            oi.setOrder(order); // IMPORTANT
            oi.setImageUrl(item.getImageUrl());
            return oi;
        }).toList();

        order.setItems(orderItems);

        // Save everything together
        Order savedOrder = orderRepository.save(order);

        // Clear cart
        cartRepository.deleteByUserEmail(email);

        return savedOrder;
    }

    public List<Order> getOrdersByUser(String email) {
        return orderRepository.findByUserEmail(email);
    }
    public Order cancelOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus("CANCELLED");

        return orderRepository.save(order);
    }
}