
package com.example;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubChildCatResponse {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("SubChild_Categories")
    @Expose
    private List<SubChildCategory> subChildCategories = null;

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

    public List<SubChildCategory> getSubChildCategories() {
        return subChildCategories;
    }

    public void setSubChildCategories(List<SubChildCategory> subChildCategories) {
        this.subChildCategories = subChildCategories;
    }

}
