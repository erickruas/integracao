package com.labs.integracao.domain;

import lombok.Data;

import java.util.List;

@Data
public class Customer {

    private Long id_usuario;
    private String nome;
    List<Order> orders;

}
