package com.sm_kitchen.service.impl;

import com.sm_kitchen.bean.Cart;
import com.sm_kitchen.bean.Dish;
import com.sm_kitchen.service.CartService;

import java.util.List;

public class CartServiceImpl implements CartService {
    private Cart cart;

    public CartServiceImpl() {
        this.cart = new Cart();
    }

    @Override
    public Cart addToCart(Dish dish) {
        if (dish != null) {
            // Add the item to the shopping cart
            List<Dish> items = cart.getItems();
            items.add(dish);

            // Update the total of the shopping cart
            cart.setTotal(cart.getTotal() + dish.getPrice());

            return cart;
        } else {
            // Handle the case where the dish is null
            throw new IllegalArgumentException("Dish cannot be null");
        }
    }

    @Override
    public Cart getCart() {
        // Return the current status of the shopping cart 
        return cart;
    }

    @Override
    public Cart removeFromCartA(List<Dish> dishes, Dish dish) {
        if (dish != null && !dishes.isEmpty()) {            

            for (int i = 0; i < dishes.size(); i++) {
                Dish item = dishes.get(i);
                if (dish.getName().equals(item.getName())) {
                    dishes.remove(i);
                    break;
                }
            }

            //get total
            double total = 0;
            for (int i = 0; i < dishes.size(); i++) {
                total += dishes.get(i).getPrice();
            }

            // Update the total of the shopping cart
            cart.setTotal(total);
            cart.setItems(dishes);

            return cart;
        } else {
            // Handle the case where the dish is null
            throw new IllegalArgumentException("Dish cannot be null");
        }
    }
}
