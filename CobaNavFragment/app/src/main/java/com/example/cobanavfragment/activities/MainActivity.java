package com.example.cobanavfragment.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.cobanavfragment.R;
import com.example.cobanavfragment.fragments.AccountFragment;
import com.example.cobanavfragment.fragments.HistoryFragment;
import com.example.cobanavfragment.fragments.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar_main);


        bottomNavigationView = findViewById(R.id.bottom_nav_main);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()){
                    case R.id.menu_home:
                        toolbar.setTitle(R.string.menu_home);
                        setSupportActionBar(toolbar);
                        fragment = new HomeFragment();
                        loadFragment(fragment);
                        return true;

                    case R.id.menu_history:
                        toolbar.setTitle(R.string.menu_history);
                        setSupportActionBar(toolbar);
                        fragment = new HistoryFragment();
                        loadFragment(fragment);
                        return true;

                    case R.id.menu_account:
                        toolbar.setTitle(R.string.menu_account);
                        setSupportActionBar(toolbar);
                        fragment = new AccountFragment();
                        loadFragment(fragment);
                        return true;
                }
                return false;
            }
        });
    }
    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_main, fragment);
        transaction.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        toolbar.setTitle(R.string.menu_home);
        setSupportActionBar(toolbar);
        bottomNavigationView.setSelectedItemId(R.id.menu_history); /*mulai dimana saat run aplikasi */
//        Fragment fragment = new HomeFragment();
//        loadFragment(fragment);
    }
}
