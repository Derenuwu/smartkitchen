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
    public synchronized Cart addToCart(Dish dish) {
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
    public synchronized Cart removeFromCart(Dish dish) {
        if (dish != null) {
            // Remove the item from the shopping cart
            List<Dish> items = cart.getItems();
            double total = cart.getTotal();

            for (int i = 0; i < items.size(); i++) {
                Dish item = items.get(i);
                if (item.getId() == dish.getId()) {
                    total -= item.getPrice();
                    items.remove(i);
                    break;
                }
            }

            // Update the total of the shopping cart
            cart.setTotal(total);

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
}
