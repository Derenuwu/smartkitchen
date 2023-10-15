package  com.sm_kitchen.dao;

import java.util.List;

import  com.sm_kitchen.bean.Dish;

public interface DishDao {
   List<Dish> selectAll();
}
