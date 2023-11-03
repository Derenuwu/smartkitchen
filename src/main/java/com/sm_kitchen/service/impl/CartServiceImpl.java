package com.sm_kitchen.service.impl;

import java.util.List;

import com.sm_kitchen.bean.Cart;
import com.sm_kitchen.bean.Dish;
import com.sm_kitchen.service.CartService;

public class CartServiceImpl implements CartService {
    private Cart cart;

    public CartServiceImpl() {
        this.cart = new Cart();
    }

    @Override
    public Cart addToCart(Dish dish) {
        // Implement the logic of adding items to the shopping cart here
        // You can handle product addition according to specific needs, such as updating
        // the items and total of the shopping cart
        cart.getItems().add(dish);
        cart.setTotal(cart.getTotal() + dish.getPrice());

        return cart;
    }

    @Override
    public Cart removeFromCart(Dish dish) {
        // Implement the logic of removing items from the shopping cart here
        // You need to find where the item is in the shopping cart and remove it from
        // the items list
        // Update the total of the shopping cart at the same time

        List<Dish> items = cart.getItems();
        double total = cart.getTotal();

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == dish.getId()) {
                total -= items.get(i).getPrice();
                items.remove(i);
                break;
            }
        }

        cart.setTotal(total);

        return cart;
    }

    @Override
    public Cart getCart() {
        // Return the current status of the shopping cart
        return cart;
    }
}
