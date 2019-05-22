package com.app.jpr.market.models.tablayoutresponse;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TabSubChildCatRequest {

    @SerializedName("c_id")
    @Expose
    private String cId;

    public String getCId() {
        return cId;
    }

    public void setCId(String cId) {
        this.cId = cId;
    }

}