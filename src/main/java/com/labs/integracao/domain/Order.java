package com.labs.integracao.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Order {

    private Long id_pedido;
    private LocalDateTime data_compra;
    private List<Product> products;
    private Double total;

}
