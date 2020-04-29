package com.uc.newerror2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextInput = findViewById(R.id.editText_Input);

    }

    public void startService(View v){
        String input = editTextInput.getText().toString();

        Intent serviceIntent = new Intent(this,ExampleService.class);
        serviceIntent.putExtra("inputExtra",input);

        startService(serviceIntent);
    }

    public void stopService(View v){
        Intent serviceIntent = new Intent(this,ExampleService.class);
        stopService(serviceIntent);
    }
}
