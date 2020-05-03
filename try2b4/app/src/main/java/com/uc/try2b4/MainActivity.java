package com.uc.try2b4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    items me;
    array itemlist1 = new array();
    private RecyclerView recyclerview;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutmanager;
    private ArrayList<items> itemlist;
    private static boolean press = false;

    public static final String SHARED_PREFS = "sharedPrefs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createitemlist();
        buildRecyclerView();

        //Floatin Action Button
        FloatingActionButton addU = findViewById(R.id.main_button_FAB);
        addU.setOnClickListener(this);

        //Carditem & Recycled View


    }

    @Override
    public void onClick(View v) {
        if (v.getId() ==R.id.main_button_FAB){
            Intent Unew = new Intent(MainActivity.this, AddActivity.class);
            if (!itemlist.isEmpty()){
                itemlist1.setItemlist(itemlist);
            }

            Unew.putExtra(AddActivity.transfer,itemlist1);
            startActivity(Unew);
            finish();
        }
    }

    public static final String transfer1 = "what";
    public void createitemlist(){
        itemlist = new ArrayList<>();
        if(!loadArray().isEmpty()){
            loadArray();
        }
        if (getIntent().getParcelableExtra(transfer1)!=null){
            itemlist1 = getIntent().getParcelableExtra(transfer1);
            itemlist = itemlist1.getItemlist();
            saveArray(itemlist);
            //itemlist.add(new items(me.getMtext1(),me.getMtext2(),me.getMtext3(),R.drawable.face,R.drawable.location));
        }

    }

    public void buildRecyclerView(){
        recyclerview = findViewById(R.id.main_rView);
        recyclerview.setHasFixedSize(true);
        layoutmanager = new LinearLayoutManager(this);
        adapter = new Adapter(itemlist);
        recyclerview.setLayoutManager(layoutmanager);
        recyclerview.setAdapter(adapter);
    }


    public void saveArray(ArrayList<items> array){
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(array);
        editor.putString("task list",json);
        editor.apply();
    }
    public ArrayList<items> loadArray() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString("task list", null);
        Type type = new TypeToken<ArrayList<items>>() {}.getType();
        itemlist = gson.fromJson(json,type);

        if(itemlist ==null) {
            itemlist = new ArrayList<items>();
        }
        return itemlist;
    }
    @Override
    public void onBackPressed() {

//        if(backPresedTime+2000 > System.currentTimeMillis()){
//            backToast.cancel();
//            super.onBackPressed();
//            return;
//        }else{
//
//            backToast = Toast.makeText(getBaseContext(),"HELLO", Toast.LENGTH_SHORT);
//            backToast.show();
//        }
        if (press) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            finish();
            startActivity(intent);

        } else {

        }
        this.press = true;
        Toast.makeText(this,"Back again to exit", Toast.LENGTH_SHORT).show();
        //backPresedTime = System.currentTimeMillis();
    }

}


