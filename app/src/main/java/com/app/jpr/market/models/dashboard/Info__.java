
package com.app.jpr.market.models.dashboard;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info__ {

    @SerializedName("p_manufecture_details")
    @Expose
    private String pManufectureDetails;

    public String getPManufectureDetails() {
        return pManufectureDetails;
    }

    public void setPManufectureDetails(String pManufectureDetails) {
        this.pManufectureDetails = pManufectureDetails;
    }

}
