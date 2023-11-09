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

@WebServlet("/api/add-to-cart")
public class AddToCartServlet extends HttpServlet {
    private CartService cartService = new CartServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get JSON data from the request
        String requestBody = request.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);

        // Parse the JSON data into a Dish object (the front end should send the product
        // information to be added to the shopping cart)
        ObjectMapper objectMapper = new ObjectMapper();
        Dish dish = objectMapper.readValue(requestBody, Dish.class);

        // Handle the logic of adding to the shopping cart
        Cart cart = cartService.addToCart(dish); // Use the shopping cart service here to add items to the shopping cart

        // Construct response object
        String jsonResponse = objectMapper.writeValueAsString(cart);

        // Set the response Content-Type to JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // send response
        response.getWriter().write(jsonResponse);
    }
}
