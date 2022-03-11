package com.labs.integracao.domain;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer {

    private Long id_usuario;
    private String nome;
    List<Order> orders;

    public Customer(Long id_usuario, String nome) {
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order){
        orders.add(order);
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        return getId_usuario().equals(customer.getId_usuario()) && getNome().equals(customer.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_usuario(), getNome());
    }
}
