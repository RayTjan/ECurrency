package com.example.ecurrency.model;

import android.os.Parcel;
import android.os.Parcelable;

public class News {

    private String title;
    private String description;
    private String newsimg;

    public News(){

    }

    public News(String title, String description, String newsimg) {
        this.title = title;
        this.description = description;
        this.newsimg = newsimg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNewsimg() {
        return newsimg;
    }

    public void setNewsimg(String newsimg) {
        this.newsimg = newsimg;
    }


    public int describeContents() {
        return 0;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeString(this.newsimg);
    }

    protected News(Parcel in) {
        this.title = in.readString();
        this.description = in.readString();
        this.newsimg = in.readString();
    }

    public static final Parcelable.Creator<News> CREATOR = new Parcelable.Creator<News>() {
        @Override
        public News createFromParcel(Parcel source) {
            return new News(source);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };
}

