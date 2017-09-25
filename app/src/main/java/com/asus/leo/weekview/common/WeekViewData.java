package com.asus.leo.weekview.common;


import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public class WeekViewData implements Parcelable {

    private String content;

    private Drawable image;

    public void setContent(String content){
        this.content = content;
    }

    public String getContent(){
        return this.content;
    }

    public void setImage(Drawable image){
        this.image = image;
    }

    public Drawable getImage(){
        return this.image;
    }

    public WeekViewData() {

    }

    protected WeekViewData(Parcel in) {

    }

    public static final Creator<WeekViewData> CREATOR = new Creator<WeekViewData>() {
        @Override
        public WeekViewData createFromParcel(Parcel in) {
            return new WeekViewData(in);
        }

        @Override
        public WeekViewData[] newArray(int size) {
            return new WeekViewData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
