package com.intermediate.component.redis.dto;


import java.math.BigDecimal;

public class ProductDetailDto {
    private String key;
    private String desc;
    private BigDecimal price;
    private String currency;
    private BigDecimal stock;

    public String getKey() {
        return key;
    }

    public String getDesc() {
        return desc;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getStock() {
        return stock;
    }
}
