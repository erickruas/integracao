package com.labs.integracao.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_EVEN;

public class Product {

    @JsonProperty("product_id")
    private final Long productId;
    @JsonProperty("value")
    private BigDecimal value;

    private Product(Long productId, BigDecimal value) {
        this.productId = productId;
        this.value = value.setScale(2, HALF_EVEN);
    }

    public static Product createProduct(Long productId, BigDecimal value) {
        return new Product(productId, value);
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
