package com.sm_kitchen.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.sm_kitchen.bean.Dish;
import com.sm_kitchen.dao.DishDao;
import com.sm_kitchen.dao.impl.DishDaoImpl;
import com.sm_kitchen.exception.DishGetException;
import com.sm_kitchen.service.DishService;
import com.sm_kitchen.utils.DBUtil;

public class DishServiceImpl implements DishService {

   private DishDao dishDao = new DishDaoImpl();

   @Override
   public List<Dish> getDishes() throws DishGetException {
      List<Dish> result = null;
      try (Connection connection = DBUtil.getConnection()) {
         connection.setAutoCommit(false);
         result = this.dishDao.selectAll();
         connection.commit();
      } catch (SQLException e) {
         throw new DishGetException("Dish display error");
      }
      return result;
   }

}
