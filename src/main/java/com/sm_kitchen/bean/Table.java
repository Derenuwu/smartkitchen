package com.sm_kitchen.bean;
import java.util.ArrayList;
import java.util.List;

public class Table {
   private Long id;
   private String name;
   private List<Order> orders;

   public Table(){
      this(0L,null);
   }
   public Table(Long id, String name) {
      this.id = id;
      this.name = name;
      this.orders = new ArrayList<>();
   }
   public Long getId() {
      return id;
   }
   public void setId(Long id) {
      this.id = id;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public List<Order> getOrders() {
      return orders;
   }
   public void setOrders(List<Order> orders) {
      this.orders = orders;
   }
   @Override
   public String toString() {
      return "Table [id=" + id + ", name=" + name + ", orders=" + orders + "]";
   }
   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      result = prime * result + ((name == null) ? 0 : name.hashCode());
      result = prime * result + ((orders == null) ? 0 : orders.hashCode());
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
      Table other = (Table) obj;
      if (id == null) {
         if (other.id != null)
            return false;
      } else if (!id.equals(other.id))
         return false;
      if (name == null) {
         if (other.name != null)
            return false;
      } else if (!name.equals(other.name))
         return false;
      if (orders == null) {
         if (other.orders != null)
            return false;
      } else if (!orders.equals(other.orders))
         return false;
      return true;
   }
   
   public boolean addOrder(Order order){
      if(order==null){
         return false;
      }
      return this.orders.add(order);
   }

   

   
}
