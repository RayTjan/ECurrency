package com.example.ecurrency.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.ecurrency.R;
import com.example.ecurrency.adapter.idrArray;
import com.example.ecurrency.fragment.GraphFragment;

public class SplashScreenActivity extends AppCompatActivity {
    private int SLEEP_TIMER = 2;
    GraphFragment graphpage = new GraphFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getSupportActionBar().hide();

        setContentView(R.layout.activity_splash_screen);

        idrArray.SetIDRFirst();
        LogoLauncher logoLauncher = new LogoLauncher();
        logoLauncher.start();

    }
    private class LogoLauncher extends Thread{
        public void run(){
            try{
                sleep(2000 * SLEEP_TIMER);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
            startActivity(intent);
            SplashScreenActivity.this.finish();
        }
    }
}
