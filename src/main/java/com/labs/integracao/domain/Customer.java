package com.labs.integracao.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer {

    private Long user_id;
    private String name;
    List<Order> orders;

    public Customer(Long user_id, String nome) {
        this.user_id = user_id;
        this.name = nome;
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order){
        orders.add(order);
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return user_id.equals(customer.user_id) && name.equals(customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, name);
    }
}
