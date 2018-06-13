package com.amangarg.recrotask2.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ProductsResponse implements Serializable {

    @SerializedName("ProductName")
    public String mProductName;

    @SerializedName("ProductId")
    public Integer mProductId;

    @SerializedName("Subscribed")
    public boolean mSubscribed;

    @SerializedName("Trial")
    public boolean mTrial;

    @SerializedName("New")
    public boolean mNew;

}