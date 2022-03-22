package com.labs.integracao.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.math.RoundingMode.HALF_EVEN;

public class Order {

    @JsonProperty("order_id")
    private final Long orderId;
    @JsonProperty("total")
    private BigDecimal total;
    @JsonProperty("date")
    private LocalDate date;
    @JsonProperty("products")
    private List<Product> products;

    private Order(Long orderId, LocalDate date) {
        this.orderId = orderId;
        this.date = date;
        this.products = new ArrayList<>();
        this.total = BigDecimal.ZERO;
    }

    public static Order createOrder(Long orderId, LocalDate date) {
        return new Order(orderId, date);
    }

    public void addProduct(Product product) {
        products.add(product);
        total = this.getTotal().add(product.getValue()).setScale(2, HALF_EVEN);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return orderId.equals(order.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, getTotal());
    }

    public Long getOrderId() {
        return orderId;
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
}
