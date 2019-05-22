package com.app.jpr.market.models.fragmentdatamodel;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TabSubChildFragmentRequest {

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