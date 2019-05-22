package com.app.jpr.market.models.tablayouttitle;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TabLayoutTitleRequest {

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