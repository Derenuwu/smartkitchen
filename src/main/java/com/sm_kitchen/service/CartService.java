package com.sm_kitchen.service;

import com.sm_kitchen.bean.Cart;
import com.sm_kitchen.bean.Dish;

public interface CartService {
    Cart addToCart(Dish dish);
    Cart removeFromCart(Dish dish);
    Cart getCart();
}