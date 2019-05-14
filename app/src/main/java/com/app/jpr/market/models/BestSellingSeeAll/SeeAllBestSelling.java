
package com.app.jpr.market.models.BestSellingSeeAll;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SeeAllBestSelling {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("Best Selling")
    @Expose
    private List<BestSellingNew> bestSelling = null;

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

    public List<BestSellingNew> getBestSelling() {
        return bestSelling;
    }

    public void setBestSelling(List<BestSellingNew> bestSelling) {
        this.bestSelling = bestSelling;
    }

}
