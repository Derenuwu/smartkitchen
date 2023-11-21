package com.sm_kitchen.service;

import java.util.List;

import com.sm_kitchen.bean.Cart;
import com.sm_kitchen.bean.Dish;

public interface CartService {
    Cart addToCart(Dish dish);
    Cart removeFromCartA(List<Dish> dishes, Dish dish);
    Cart getCart();
}