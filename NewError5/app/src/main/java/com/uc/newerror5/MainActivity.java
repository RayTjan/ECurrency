package com.uc.newerror5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    String caramelas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getStudent();
        Button henshin = findViewById(R.id.button);
        henshin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView change = findViewById(R.id.changed);
                change.setText(caramelas);
            }
        });
    }

    public void getStudent(){
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://data.fixer.io/api/latest?access_key=ac31820a29489ce18b9208b5c5c5d557";
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try{
                    String result = new String (responseBody);
                    JSONObject responseObject = new JSONObject(result);
                    JSONObject rates = responseObject.getJSONObject("rates");
                    Double IDR = rates.getDouble("IDR");
                    caramelas = Double.toString(IDR);
                }catch (Exception e){
                    Log.d("ExceptionStudent", "onSuccess: " + e.getMessage());
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }
}
