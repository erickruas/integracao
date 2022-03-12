package com.labs.integracao.domain;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_EVEN;

public class Product {

    private Long product_id;
    private BigDecimal value;

    public Product(Long product_id, BigDecimal value) {
        this.product_id = product_id;
        this.value = value.setScale(2, HALF_EVEN);
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}

