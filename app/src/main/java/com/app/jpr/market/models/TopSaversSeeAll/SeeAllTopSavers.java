
package com.app.jpr.market.models.TopSaversSeeAll;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SeeAllTopSavers {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("Today Saver")
    @Expose
    private List<TodaySaver> todaySaver = null;

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

    public List<TodaySaver> getTodaySaver() {
        return todaySaver;
    }

    public void setTodaySaver(List<TodaySaver> todaySaver) {
        this.todaySaver = todaySaver;
    }

}
