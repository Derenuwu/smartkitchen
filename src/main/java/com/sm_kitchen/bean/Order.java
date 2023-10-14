package com.sm_kitchen.bean;


public class Order {
   private Dish dish;
   private Integer quantity;
   public Order() {
      this(null, null);
   }
   public Order(Dish dish, Integer quantity) {
      this.dish = dish;
      this.quantity = quantity;
   }
   public Dish getDish() {
      return dish;
   }
   public void setDish(Dish dish) {
      this.dish = dish;
   }
   public Integer getQuantity() {
      return quantity;
   }
   public void setQuantity(Integer quantity) {
      this.quantity = quantity;
   }
   @Override
   public String toString() {
      return "Order [dish=" + dish + ", quantity=" + quantity + "]";
   }
   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((dish == null) ? 0 : dish.hashCode());
      result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
      return result;
   }
   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Order other = (Order) obj;
      if (dish == null) {
         if (other.dish != null)
            return false;
      } else if (!dish.equals(other.dish))
         return false;
      if (quantity == null) {
         if (other.quantity != null)
            return false;
      } else if (!quantity.equals(other.quantity))
         return false;
      return true;
   }

   
}
