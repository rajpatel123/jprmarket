
package com.app.jpr.market.models.dashboard;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Category implements Parcelable {

    @SerializedName("cat_id")
    @Expose
    private String catId;
    @SerializedName("cat_title")
    @Expose
    private String catTitle;
    @SerializedName("cat_image")
    @Expose
    private String catImage;
    @SerializedName("cat_desc")
    @Expose
    private String catDesc;
    @SerializedName("d_title")
    @Expose
    private String dTitle;

    protected Category(Parcel in) {
        catId = in.readString();
        catTitle = in.readString();
        catImage = in.readString();
        catDesc = in.readString();
        dTitle = in.readString();
    }

    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getCatTitle() {
        return catTitle;
    }

    public void setCatTitle(String catTitle) {
        this.catTitle = catTitle;
    }

    public String getCatImage() {
        return catImage;
    }

    public void setCatImage(String catImage) {
        this.catImage = catImage;
    }

    public String getCatDesc() {
        return catDesc;
    }

    public void setCatDesc(String catDesc) {
        this.catDesc = catDesc;
    }

    public String getDTitle() {
        return dTitle;
    }

    public void setDTitle(String dTitle) {
        this.dTitle = dTitle;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(catId);
        dest.writeString(catTitle);
        dest.writeString(catImage);
        dest.writeString(catDesc);
        dest.writeString(dTitle);
    }
}
