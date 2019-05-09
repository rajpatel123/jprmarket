
package com.app.jpr.market.models.subCategory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubCategory {

    @SerializedName("cat_id")
    @Expose
    private String catId;
    @SerializedName("sub_id")
    @Expose
    private String subId;
    @SerializedName("sub_title")
    @Expose
    private String subTitle;
    @SerializedName("sub_image")
    @Expose
    private String subImage;
    @SerializedName("d_title")
    @Expose
    private String dTitle;

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getSubImage() {
        return subImage;
    }

    public void setSubImage(String subImage) {
        this.subImage = subImage;
    }

    public String getDTitle() {
        return dTitle;
    }

    public void setDTitle(String dTitle) {
        this.dTitle = dTitle;
    }

}
