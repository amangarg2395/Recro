package com.amangarg.recrotask2.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ProductsRequestBody implements Serializable {

    @SerializedName("userid")
    public Double mUserId;

    @SerializedName("companyid")
    public Double mCompanyId;

    @SerializedName("token")
    public String mToken;

    public ProductsRequestBody(Double mUserId, Double mCompanyId, String mToken) {
        this.mUserId = mUserId;
        this.mCompanyId = mCompanyId;
        this.mToken = mToken;
    }
}
