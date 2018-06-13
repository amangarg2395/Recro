package com.amangarg.recrotask2.models;

public class ProductModel {
    private String ProductName;
    private Integer ProductId;
    private Boolean Subscribed;

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public Integer getProductId() {
        return ProductId;
    }

    public void setProductId(Integer productId) {
        ProductId = productId;
    }

    public Boolean getSubscribed() {
        return Subscribed;
    }

    public void setSubscribed(Boolean subscribed) {
        Subscribed = subscribed;
    }

    public Boolean getTrial() {
        return Trial;
    }

    public void setTrial(Boolean trial) {
        Trial = trial;
    }

    public Boolean getNew() {
        return New;
    }

    public void setNew(Boolean aNew) {
        New = aNew;
    }

    private Boolean Trial;
    private Boolean New;
}
