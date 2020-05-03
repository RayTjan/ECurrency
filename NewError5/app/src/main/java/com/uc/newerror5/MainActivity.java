package com.uc.newerror5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

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
        String url = "http://newsapi.org/v2/top-headlines?category=business&apiKey=e692335ecadf4fa881abc2d91d9d83c1";
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try{
                    String result = new String (responseBody);
                    JSONObject responseObject = new JSONObject(result);
                    JSONObject rates = responseObject.getJSONObject("rates");
                    JSONArray list =  responseObject.getJSONArray("articles");
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
<<<<<<< HEAD
//    public void getnotin(){
//        final ArrayList<Student> students = new ArrayList<>();
//        AsyncHttpClient client = new AsyncHttpClient();
//        String url = "http://newsapi.org/v2/top-headlines?category=business&apiKey=e692335ecadf4fa881abc2d91d9d83c1";
//
=======


//    String result = new String (responseBody);
//    JSONObject responseObject = new JSONObject(result);
//    JSONArray list =  responseObject.getJSONArray("student");
//                    for (int i = 0; i < list.length(); i++){
//        JSONObject obj = list.getJSONObject(i);
//        Student s = new Student(obj.getString("id"),obj.getString("nim"),
//                obj.getString("name"),obj.getString("email"),obj.getString("phone"),
//                obj.getString("gender"), obj.getJSONArray("").getString(""));
//        JSONArray arr = obj.getJSONArray("rates");
//        arr.getDouble(1)
//        students.add(s);
//    }


//    showStudent(students);
//    public void getStudent(){
//        AsyncHttpClient client = new AsyncHttpClient();
//        String url = "http://data.fixer.io/api/latest?access_key=ac31820a29489ce18b9208b5c5c5d557";
>>>>>>> 678eba9f776fec0fcaa2e1d5da322f340eeae0a5
//        client.get(url, new AsyncHttpResponseHandler() {
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
//                try{
//                    String result = new String (responseBody);
//                    JSONObject responseObject = new JSONObject(result);
<<<<<<< HEAD
//                    JSONArray list =  responseObject.getJSONArray("articles");
//                    for (int i = 0; i < list.length(); i++){
//                        JSONObject obj = list.getJSONObject(i);
//                        Student s = new Student(obj.getString("author"),obj.getString("title"),
//                                obj.getString("description"),obj.getString("url"),obj.getString("content"),
//                                obj.getString("publishedAt"));
//                        students.add(s);
//                    }
//                    showStudent(students);
=======
//                    JSONObject rates = responseObject.getJSONObject("rates");
//                    Double IDR = rates.getDouble("IDR");
//                    caramelas = Double.toString(IDR);
>>>>>>> 678eba9f776fec0fcaa2e1d5da322f340eeae0a5
//                }catch (Exception e){
//                    Log.d("ExceptionStudent", "onSuccess: " + e.getMessage());
//                }
//            }
<<<<<<< HEAD
=======
//
//            @Override
//            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//
//            }
//        });
//    }
>>>>>>> 678eba9f776fec0fcaa2e1d5da322f340eeae0a5
}
