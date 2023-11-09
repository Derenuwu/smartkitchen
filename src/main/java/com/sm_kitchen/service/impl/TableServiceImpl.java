package com.teamofdream.smart_kitchen.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.teamofdream.smart_kitchen.bean.Table;
import com.teamofdream.smart_kitchen.dao.TableDao;
import com.teamofdream.smart_kitchen.dao.impl.TableDaoImpl;
import com.teamofdream.smart_kitchen.exception.DishGetException;
import com.teamofdream.smart_kitchen.service.TableService;
import com.teamofdream.smart_kitchen.utils.DBUtil;

public class TableServiceImpl implements TableService {

   private TableDao tableDao = new TableDaoImpl(); // moditly db record obj

   @Override
   public List<Table> getAllTables() throws Exception {
      List<Table> result = null;
      try ( Connection connection = DBUtil.getConnection() ) {
         connection.setAutoCommit(false);
         
         // todo
         result = tableDao.selectAll();

         connection.commit();
      } catch (SQLException e) {
         throw new DishGetException("Dish display error");
      }
      return result;
   }

   @Override
   public Table getTableinfo(Integer tableid) throws Exception {
      Table tableinfo = null;
      try ( Connection connection = DBUtil.getConnection() ) {
         connection.setAutoCommit(false);
         
         // todo
         tableinfo = tableDao.selectDishByTableID(tableid);

         connection.commit();
      } catch (SQLException e) {
         throw new DishGetException("Dish display error");
      }
      return tableinfo;
   }
   
}
