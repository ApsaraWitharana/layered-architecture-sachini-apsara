package com.example.layeredarchitecture.model;

import java.math.BigDecimal;

public class CustomDTO {
    private String id;
    private String name;
    private String code;
    private String description;
    private BigDecimal unitPrice;
    private int qtyOnHand;

    public CustomDTO(){

    }

    public CustomDTO(String id, String name, String code, String description, BigDecimal unitPrice, int qtyOnHand) {

        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qtyOnHand = qtyOnHand;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }
}
