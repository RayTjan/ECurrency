package com.example.ecurrency.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ecurrency.R;
import com.example.ecurrency.fragment.CalculatorFragment;
import com.example.ecurrency.fragment.DashboardFragment;
import com.example.ecurrency.fragment.GraphFragment;
import com.example.ecurrency.fragment.ReminderFragment;
import com.example.ecurrency.fragment.SettingsFragment;
import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

public class MainActivity extends AppCompatActivity {

    private GraphFragment GraphFragment;
    private ReminderFragment ReminderFragment;
    private DashboardFragment DashboardFragment;
    private CalculatorFragment CalculatorFragment;
    private SettingsFragment SettingsFragment;

    SpaceNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GraphFragment = new GraphFragment();
        ReminderFragment = new ReminderFragment();
        DashboardFragment = new DashboardFragment();
        CalculatorFragment = new CalculatorFragment();
        SettingsFragment = new SettingsFragment();

        navigationView = findViewById(R.id.main_nav);
        navigationView.initWithSaveInstanceState(savedInstanceState);
        navigationView.showIconOnly();

        navigationView.addSpaceItem(new SpaceItem("nav_graph", R.drawable.line_chart));
        navigationView.addSpaceItem(new SpaceItem("nav_reminder", R.drawable.bell));
        navigationView.addSpaceItem(new SpaceItem("nav_calculator", R.drawable.calculator));
        navigationView.addSpaceItem(new SpaceItem("nav_settings", R.drawable.ic_settings_black_24dp));
//        navigationView.changeCurrentItem(DashboardFragment);

        navigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
                navigationView.setCentreButtonSelectable(true);
                setFragment(DashboardFragment);
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
                switch(itemIndex){
                    case 0:
                        setFragment(GraphFragment);
                        return;
                    case 1:
                        setFragment(ReminderFragment);
                        return;
                    case 2:
                        setFragment(CalculatorFragment);
                        return;
                    case 3:
                        setFragment(SettingsFragment);
                        return;
                    default:
                        setFragment(DashboardFragment);
                        return;
                }
            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {
            }
        });
    }
    private void setFragment (Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }
}
