
package com.app.jpr.market.models.tablayouttitle;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TabLayoutTitleResponse {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("SubChild_Categories")
    @Expose
    private List<SubChildTitle2Category> subChildTitle2Categories = null;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<SubChildTitle2Category> getSubChildTitle2Categories() {
        return subChildTitle2Categories;
    }

    public void setSubChildCategories(List<SubChildTitle2Category> subChildTitle2Categories) {
        this.subChildTitle2Categories = subChildTitle2Categories;
    }

}
