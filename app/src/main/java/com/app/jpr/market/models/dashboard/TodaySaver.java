
package com.app.jpr.market.models.dashboard;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TodaySaver {

    @SerializedName("p_id")
    @Expose
    private String pId;
    @SerializedName("p_title")
    @Expose
    private String pTitle;
    @SerializedName("p_image")
    @Expose
    private String pImage;
    @SerializedName("p_desc")
    @Expose
    private String pDesc;
    @SerializedName("p_price")
    @Expose
    private String pPrice;
    @SerializedName("p_disc_price")
    @Expose
    private String pDiscPrice;
    @SerializedName("p_quantity")
    @Expose
    private String pQuantity;
    @SerializedName("p_islock_status")
    @Expose
    private String pIslockStatus;
    @SerializedName("subitems")
    @Expose
    private Subitems_ subitems;

    public String getPId() {
        return pId;
    }

    public void setPId(String pId) {
        this.pId = pId;
    }

    public String getPTitle() {
        return pTitle;
    }

    public void setPTitle(String pTitle) {
        this.pTitle = pTitle;
    }

    public String getPImage() {
        return pImage;
    }

    public void setPImage(String pImage) {
        this.pImage = pImage;
    }

    public String getPDesc() {
        return pDesc;
    }

    public void setPDesc(String pDesc) {
        this.pDesc = pDesc;
    }

    public String getPPrice() {
        return pPrice;
    }

    public void setPPrice(String pPrice) {
        this.pPrice = pPrice;
    }

    public String getPDiscPrice() {
        return pDiscPrice;
    }

    public void setPDiscPrice(String pDiscPrice) {
        this.pDiscPrice = pDiscPrice;
    }

    public String getPQuantity() {
        return pQuantity;
    }

    public void setPQuantity(String pQuantity) {
        this.pQuantity = pQuantity;
    }

    public String getPIslockStatus() {
        return pIslockStatus;
    }

    public void setPIslockStatus(String pIslockStatus) {
        this.pIslockStatus = pIslockStatus;
    }

    public Subitems_ getSubitems() {
        return subitems;
    }

    public void setSubitems(Subitems_ subitems) {
        this.subitems = subitems;
    }

}
