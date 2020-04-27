package com.example.ecurrency;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.example.ecurrency.fragment.DashboardFragment;
import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

public class MainActivity extends AppCompatActivity {

    SpaceNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.main_nav);
        navigationView.initWithSaveInstanceState(savedInstanceState);
        navigationView.addSpaceItem(new SpaceItem("", R.drawable.line_chart));
        navigationView.addSpaceItem(new SpaceItem("", R.drawable.bell));
        navigationView.addSpaceItem(new SpaceItem("", R.drawable.calculator));
        navigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_settings_black_24dp));
        navigationView.changeCurrentItem(1);

        navigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
                navigationView.setCentreButtonSelectable(true);

            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {
            }
        });
    }
}
