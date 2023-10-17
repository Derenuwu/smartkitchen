package com.sm_kitchen.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sm_kitchen.bean.Dish;
import com.sm_kitchen.dao.DishDao;
import com.sm_kitchen.utils.DBUtil;

public class DishDaoImpl implements DishDao {

   @Override
   public List<Dish> selectAll() {
      PreparedStatement ps = null;
      ResultSet rs = null;
      List<Dish> dishes = new ArrayList<Dish>(16);
      try {
         Connection connection = DBUtil.getConnection();
         String sql = "select * from dish";
         ps = connection.prepareStatement(sql);
         rs = ps.executeQuery();
         while (rs.next()) {
            Long id = rs.getLong("id");
            String name = rs.getString("name");
            Double price = rs.getDouble("price");
            Dish dish = new Dish(id, name, price);
            dishes.add(dish);
         }
      } catch (SQLException e) {
         throw new RuntimeException(e);
      } finally {
         DBUtil.close(null, ps, rs);
      }
      return dishes;
   }
   
}
