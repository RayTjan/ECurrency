package com.example.ecurrency.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Graph {

    private String state;
    private String currency;
    private String value;

    public Graph(){

    }

    public Graph(String state, String currency, String value) {
        this.state = state;
        this.currency = currency;
        this.value = value;
    }

    public String getState() {
        return state;
    }

    public void getState(String state) {
        this.state = state;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public int describeContents() {
        return 0;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.state);
        dest.writeString(this.currency);
        dest.writeString(this.value);
    }

    protected Graph(Parcel in) {
        this.state = in.readString();
        this.currency = in.readString();
        this.value = in.readString();
    }

    public static final Parcelable.Creator<Graph> CREATOR = new Parcelable.Creator<Graph>() {
        @Override
        public Graph createFromParcel(Parcel source) {
            return new Graph(source);
        }

        @Override
        public Graph[] newArray(int size) {
            return new Graph[size];
        }
    };
}

