package com.labs.integracao.domain;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_EVEN;

public class Product {

    private final Long productId;
    private BigDecimal value;

    public Product(Long productId, BigDecimal value) {
        this.productId = productId;
        this.value = value.setScale(2, HALF_EVEN);
    }

    public Long getProductId() {
        return productId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
