
package com.app.jpr.market.models.BlockBusterSeeAll;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SeeAllBlockBuster {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("Blockbuster")
    @Expose
    private List<Blockbuster> blockbuster = null;

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

    public List<Blockbuster> getBlockbuster() {
        return blockbuster;
    }

    public void setBlockbuster(List<Blockbuster> blockbuster) {
        this.blockbuster = blockbuster;
    }

}
