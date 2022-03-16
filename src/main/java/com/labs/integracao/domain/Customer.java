package com.labs.integracao.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer {

    @JsonProperty("user_id")
    private final Long userId;
    @JsonProperty("name")
    private final String name;
    @JsonProperty("orders")
    private List<Order> orders;

    public Customer(Long userId, String name) {
        this.userId = userId;
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public void addOrderAndProduct(Order order, Product product) {
        order.addProduct(product);
        orders.add(order);
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
        return userId.equals(customer.userId) && name.equals(customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name);
    }

    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

}
