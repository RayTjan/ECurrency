package com.uc.try2b4;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class array implements Parcelable {
    private static ArrayList<items> itemlist = new ArrayList<>();

    public array(){

    }

    protected array(Parcel in) {
        itemlist = in.createTypedArrayList(items.CREATOR);
    }

    public static final Creator<array> CREATOR = new Creator<array>() {
        @Override
        public array createFromParcel(Parcel in) {
            return new array(in);
        }

        @Override
        public array[] newArray(int size) {
            return new array[size];
        }
    };

    public ArrayList<items> getItemlist() {
        return itemlist;
    }

    public void setItemlist(ArrayList<items> itemlist) {
        this.itemlist = itemlist;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(itemlist);
    }
}
