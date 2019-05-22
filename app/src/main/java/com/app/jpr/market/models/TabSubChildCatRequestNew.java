package com.app.jpr.market.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TabSubChildCatRequestNew {

@SerializedName("sub_id")
@Expose
private String subId;

public String getSubId() {
return subId;
}

public void setSubId(String subId) {
this.subId = subId;
}

}