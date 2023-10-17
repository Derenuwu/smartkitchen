package com.sm_kitchen.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sm_kitchen.bean.Dish;
import com.sm_kitchen.bean.Order;
import com.sm_kitchen.bean.Table;
import com.sm_kitchen.dao.TableDao;
import com.sm_kitchen.utils.DBUtil;

public class TableDaoImpl implements TableDao {

   @Override
   public List<Table> selectAll() { // connet to db, 
      List<Table> tables = new ArrayList<Table>();
      // copy
      PreparedStatement ps = null;
      ResultSet rs = null;
      
      try {
         // get the connection obj with db
         Connection connection = DBUtil.getConnection();
         String sql = "select * from t_table";
         ps = connection.prepareStatement(sql);
         rs = ps.executeQuery(); // raw data from db
         while (rs.next()) {
            Long id = rs.getLong("id");
            String name = rs.getString("name");
            tables.add(new Table(id, name));
         }
      } catch (SQLException e) {
         throw new RuntimeException(e);
      } finally {
         DBUtil.close(null, ps, rs);
      }
      return tables;
   }

   @Override
   public Table selectDishByTableID(Integer tableId) {
      Table tableinfo = null;
      PreparedStatement ps = null;
      ResultSet rs = null;
      try {
         // get the connection obj with db
         Connection connection = DBUtil.getConnection();
         String sql = "select t_order.table_id as table_id, t_table.name as table_name, t_order.dish_id as dish_id, dish.name as dish_name, t_order.quantity as dish_quantity, dish.price as dish_price from t_order join dish on t_order.dish_id = dish.id join t_table ON t_order.table_id = t_table.id where t_order.table_id = ?;";
         ps = connection.prepareStatement(sql);
         ps.setInt(1, tableId);
         rs = ps.executeQuery(); // raw data from db
         while (rs.next()) {
            if (tableinfo == null) {
               tableinfo = new Table(rs.getLong("table_id"), rs.getString("table_name"));
            }
            Dish temp = new Dish(rs.getLong("dish_id"), rs.getString("dish_name"), rs.getDouble("dish_price"));
            Integer quantity = rs.getInt("dish_quantity");
            tableinfo.addOrder(new Order(temp, quantity));
         }
      } catch (SQLException e) {
         throw new RuntimeException(e);
      } finally {
         DBUtil.close(null, ps, rs);
      }
      return tableinfo;
   }
   
}
