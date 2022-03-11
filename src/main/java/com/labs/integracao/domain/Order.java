package com.labs.integracao.domain;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {

    private Long id_pedido;
    private LocalDate data_compra;
    private List<Product> products;
    private Double total;

    public Order(Long id_pedido, LocalDate data_compra) {
        this.id_pedido = id_pedido;
        this.data_compra = data_compra;
        this.products = new ArrayList<>();
        this.total = 0.00;
    }

    public void addProduct(Product product){
        products.add(product);
        total = total + product.getValor_produto();
    }

    public Long getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Long id_pedido) {
        this.id_pedido = id_pedido;
    }

    public LocalDate getData_compra() {
        return data_compra;
    }

    public void setData_compra(LocalDate data_compra) {
        this.data_compra = data_compra;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(getId_pedido(), order.getId_pedido());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_pedido());
    }
}