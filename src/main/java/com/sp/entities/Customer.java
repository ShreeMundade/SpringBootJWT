package com.sp.entities;


import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table(name="SprintCustomers")
public class Customer extends User  {



   
   public Customer() {
       super();
   }
   public Customer(double creditbal) {
       super();
       this.creditbal = creditbal;
   }
   public Customer(String name, String email, String password, String role, double creditbal) {
       super(name, email, password, role);
       this.creditbal = creditbal;
   }
   public Customer(Long id, String name, String email, String password, String role, double creditbal) {
       super(id, name, email, password, role);
       this.creditbal = creditbal;
   }
   @Override
   public String toString() {
       return super.toString() + "Customer [creditbal=" + creditbal + "]";
   }
   private double creditbal;
   
   
   
   public double getCreditbal() {
       return creditbal;
   }
   public void setCreditbal(double creditbal) {
       this.creditbal = creditbal;
   }
}
