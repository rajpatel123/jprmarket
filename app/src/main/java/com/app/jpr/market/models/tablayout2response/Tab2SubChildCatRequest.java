package com.app.jpr.market.models.tablayout2response;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tab2SubChildCatRequest {

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