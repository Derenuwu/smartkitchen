package com.sm_kitchen.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sm_kitchen.bean.Order;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class OrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Process order logic related to front-end POST requests
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        try {
            // Parse the order data sent by the front end
            String requestBody = request.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);
            ObjectMapper objectMapper = new ObjectMapper();
            Order newOrder = objectMapper.readValue(requestBody, Order.class);

            // Here you can perform operations such as adding orders to the shopping cart or database
            List<Order> newOrders = addOrderToCart(newOrder);

            // Send the JSON response of the new order back to the front end
            objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(newOrders);
            out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
            out.println("An error occurred while creating the order.");
        }
    }

    //Logic for adding orders to shopping cart or database
    private List<Order> addOrderToCart(Order newOrder) {
        List<Order> orders = new ArrayList<>();
        //Add order to shopping cart or database
        orders.add(newOrder); 
        return orders;
    }
}
