package com.example.ecurrency.adapter;

import android.os.Parcel;
import android.os.Parcelable;

public class Reminder implements Parcelable {
    private String title,currency,condition;
    private Double limit;
    public Reminder(){

    }
    public Reminder(String title, String currency, String condition, Double limit) {
        this.title = title;
        this.currency = currency;
        this.condition = condition;
        this.limit = limit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Double getLimit() {
        return limit;
    }

    public void setLimit(Double limit) {
        this.limit = limit;
    }

//    public static Creator<Reminder> getCREATOR() {
//        return CREATOR;
//    }
//
//    public static final Parcelable.Creator<Reminder> CREATOR = new Parcelable.Creator<Reminder>() {
//        @Override
//        public Reminder createFromParcel(Parcel in) {
//            return new Reminder(in);
//        }
//
//        @Override
//        public Reminder[] newArray(int size) {
//            return new Reminder[][size];
//        }
//    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(currency);
        dest.writeString(condition);
        dest.writeDouble(limit);
    }
}
