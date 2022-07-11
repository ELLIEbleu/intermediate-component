package com.intermediate.component.redis.dto;


import java.io.Serializable;
import java.math.BigDecimal;

public class ProductDetail implements Serializable {
    private String key;
    private String desc;
    private BigDecimal price;
    private String currency;
    private BigDecimal stock;

    public ProductDetail() {
    }

    public ProductDetail(String key, String desc, BigDecimal price, String currency, BigDecimal stock) {
        this.key = key;
        this.desc = desc;
        this.price = price;
        this.currency = currency;
        this.stock = stock;
    }

    public void setKey(String key) {
        this.key = key;
    }

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
