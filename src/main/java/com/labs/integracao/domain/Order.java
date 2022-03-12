package com.labs.integracao.domain;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.math.BigDecimal.ROUND_HALF_DOWN;
import static java.math.RoundingMode.HALF_DOWN;
import static java.math.RoundingMode.HALF_EVEN;

public class Order {

    private Long order_id;
    private BigDecimal total;
    private LocalDate date;
    private List<Product> products;

    public Order(Long order_id, LocalDate date) {
        this.order_id = order_id;
        this.date = date;
        this.products = new ArrayList<>();
        this.total = BigDecimal.ZERO;
    }

    public void addProduct(Product product){
        products.add(product);
        total = this.getTotal().add(product.getValue()).setScale(2, HALF_EVEN);
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return order_id.equals(order.order_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order_id, getTotal());
    }
}