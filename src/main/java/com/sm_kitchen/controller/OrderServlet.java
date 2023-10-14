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
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Handle GET requests related to orders here
    // You can implement order retrieval logic here

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    PrintWriter out = response.getWriter();

    try {
        // Implement the logic to retrieve orders (replace with your actual implementation)
        List<Order> orders = getOrderDataFromService(); // You should call a method to get the order data

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(orders);
        out.println(json);
    } catch (Exception e) {
        e.printStackTrace();
        out.println("An error occurred while fetching orders.");
    }
}

// Replace this with your actual order retrieval logic
private List<Order> getOrderDataFromService() {
    List<Order> orders = new ArrayList<>();
    // Add logic to retrieve orders from a data source
    return orders;
}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Handle POST requests related to orders here
    // You can implement order creation logic here

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    PrintWriter out = response.getWriter();

    try {
        // Implement the logic to create orders (replace with your actual implementation)
        Order newOrder = createOrderFromRequest(request); // You should parse the request data and create an Order object

        // Create a list containing the newOrder
        List<Order> newOrders = new ArrayList<>();
        newOrders.add(newOrder);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(newOrders);
        out.println(json);
    } catch (Exception e) {
        e.printStackTrace();
        out.println("An error occurred while creating the order.");
    }
}

private Order createOrderFromRequest(HttpServletRequest request) {
    return null;
}


}
