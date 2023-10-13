package com.sm_kitchen.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.sm_kitchen.bean.Dish;
import com.sm_kitchen.exception.DishGetException;
import com.sm_kitchen.service.DishService;
import com.sm_kitchen.service.impl.DishServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DishServlet extends HttpServlet {
   private DishService dishService = new DishServiceImpl();
   // get post put delete
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setHeader("Access-Control-Allow-Origin", "*");
      response.setContentType("application/json");
      response.setCharacterEncoding("UTF-8");
      PrintWriter out = response.getWriter();
      ObjectMapper objectMapper = new ObjectMapper();
      List<Dish> resultList = null;
      try {
         resultList = this.dishService.getDishes();
         String json = objectMapper.writeValueAsString(resultList);
         out.println(json);
      } catch (DishGetException e) {
         e.printStackTrace();
         out.println("{message : 'error on display dish meun'}");
         out.println(e.toString());
      }

   }
}
