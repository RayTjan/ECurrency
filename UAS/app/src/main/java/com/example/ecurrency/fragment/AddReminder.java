package com.example.ecurrency.fragment;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.ecurrency.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddReminder extends AppCompatActivity {


//    public void saveArray(ArrayList<items> array){
//        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
//        SharedPreferences.Editor editor = prefs.edit();
//        Gson gson = new Gson();
//        String json = gson.toJson(array);
//        editor.putString("task list",json);
//        editor.apply();
//    }
//    public ArrayList<items> loadArray() {
//        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
//        Gson gson = new Gson();
//        String json = prefs.getString("task list", null);
//        Type type = new TypeToken<ArrayList<items>>() {}.getType();
//        itemlist = gson.fromJson(json,type);
//
//        if(itemlist ==null) {
//            itemlist = new ArrayList<items>();
//        }
//        return itemlist;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reminder);



}
}
