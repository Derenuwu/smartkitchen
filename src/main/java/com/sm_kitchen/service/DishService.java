package com.sm_kitchen.service;

import java.util.List;

import com.sm_kitchen.bean.Dish;
import com.sm_kitchen.exception.DishGetException;

public interface DishService {
   List<Dish> getDishes() throws DishGetException;
}
