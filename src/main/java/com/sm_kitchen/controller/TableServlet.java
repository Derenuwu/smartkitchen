package com.sm_kitchen.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.sm_kitchen.service.TableService;
import com.sm_kitchen.service.impl.TableServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sm_kitchen.bean.Table;

// get all the tables data in db
public class TableServlet extends HttpServlet {

   // service obj
   private TableService tableService = new TableServiceImpl();

   ObjectMapper objectMapper = new ObjectMapper(); //copy

   // get post put delete update
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setHeader("Access-Control-Allow-Origin", "*");
      response.setContentType("application/json");
      response.setCharacterEncoding("UTF-8");
      PrintWriter out = response.getWriter(); // iostream obj to send the data to where requested from
      String urlpath = request.getServletPath();
      if ("/servlet/tables".equals(urlpath)) {
         getAllTables(request, response, out);
      } else if ("/servlet/tableinfo".equals(urlpath)) {
         getDishesByTableID(request, response, out);
      } else {
         out.println("404 -> no found");
      }
   }

   protected void getDishesByTableID(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws ServletException, IOException {
      Integer tableId = Integer.parseInt(request.getParameter("table_id"));
      try {
         Table tableinfo = tableService.getTableinfo(tableId);
         String json = objectMapper.writeValueAsString(tableinfo);
         out.println(json);
      } catch (Exception e) {
         e.printStackTrace();
      } 
   }

   protected void getAllTables(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws ServletException, IOException {
      try {
         List<Table> res = tableService.getAllTables();
         String json = objectMapper.writeValueAsString(res);
         out.println(json);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
