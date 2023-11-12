package com.sm_kitchen.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sm_kitchen.bean.Cart;
import com.sm_kitchen.bean.Dish;
import com.sm_kitchen.service.CartService;
import com.sm_kitchen.service.impl.CartServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/api/remove-from-cart")
public class RemoveFromCartServlet extends HttpServlet {
    private CartService cartService = new CartServiceImpl();
    private ObjectMapper objectMapper = new ObjectMapper();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get JSON data from the request
        String requestBody = request.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);

        // Parse the JSON data into a Dish object
        Dish dish = objectMapper.readValue(requestBody, Dish.class);

        // Handle the logic of removing from the shopping cart
        Cart cart = cartService.removeFromCart(dish);

        // Construct response object with updated total
        Map<String, Object> jsonResponse = new HashMap<>();
        jsonResponse.put("cart", cart.getItemsArray());  // 使用新添加的方法获取数组
        jsonResponse.put("total", cart.getTotal());

        // Set the response Content-Type to JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Send response
        response.getWriter().write(objectMapper.writeValueAsString(jsonResponse));
    }
}





