
package com.app.jpr.market.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TabSubChildCatResponseNew {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("SubChild_Categories")
    @Expose
    private List<TabSubChildCategoryNew> subChildCategories = null;

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

    public List<TabSubChildCategoryNew> getSubChildCategories() {
        return subChildCategories;
    }

    public void setSubChildCategories(List<TabSubChildCategoryNew> subChildCategories) {
        this.subChildCategories = subChildCategories;
    }

}
