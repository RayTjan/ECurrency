package com.uc.newerror5;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    String caramelas,caramelas2,caramelas3;
    String dummy,date,str,wot;
    String url;
    LineChart lineChart;
    LineDataSet lineDataSet,lineDataSet2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         dummy = "nein";
         date = "2019-02-04";
        url = "http://data.fixer.io/api/latest?access_key=ac31820a29489ce18b9208b5c5c5d557";
         wot = new StringBuffer(url).replace(url.length()-50,url.length()-44,date).toString();
        getRate1(url);
        Button henshin = findViewById(R.id.button);
         str = new StringBuffer(dummy).replace(dummy.length()-2,dummy.length()-1,date).toString();

        henshin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView change = findViewById(R.id.changed);
                TextView change2 = findViewById(R.id.changed2);
                TextView change3 = findViewById(R.id.changed3);
                change.setText(caramelas);
                change2.setText(url);
                change3.setText(date());
            }
        });

        lineChart = findViewById(R.id.linechart);
        lineChart.setTouchEnabled(true);
        lineChart.setPinchZoom(true);
        lineDataSet = new LineDataSet(ChartData(),"data set");
        lineDataSet2 = new LineDataSet(ChartData2(),"data2 set");
        ArrayList<ILineDataSet> iLineDataSets = new ArrayList<>();
        iLineDataSets.add(lineDataSet);
        iLineDataSets.add(lineDataSet2);

        LineData lineData = new LineData(iLineDataSets);
        lineChart.setData(lineData);
        lineChart.invalidate();
        lineDataSet.enableDashedLine(10f, 5f, 0f);
        lineDataSet.enableDashedHighlightLine(10f, 5f, 0f);
        lineDataSet.setColor(Color.DKGRAY);
        lineDataSet.setCircleColor(Color.DKGRAY);
        lineDataSet.setLineWidth(1f);
        lineDataSet.setCircleRadius(3f);
        lineDataSet.setDrawCircleHole(false);
        lineDataSet.setValueTextSize(9f);
        lineDataSet.setDrawFilled(true);
        lineDataSet.setFormLineWidth(1f);
        //background color
        lineChart.setBackgroundColor(Color.BLUE);

    }
    public static String date() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date curDate = new Date(System.currentTimeMillis());
        String str = formatter.format(curDate);
        return str;
    }
    public void getRate1(String url){
        AsyncHttpClient client = new AsyncHttpClient();
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
//    public void getnotin(){
//        final ArrayList<Student> students = new ArrayList<>();
//        AsyncHttpClient client = new AsyncHttpClient();
//        String url = "http://newsapi.org/v2/top-headlines?category=business&apiKey=e692335ecadf4fa881abc2d91d9d83c1";
//
//        client.get(url, new AsyncHttpResponseHandler() {
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
//                try{
//                    String result = new String (responseBody);
//                    JSONObject responseObject = new JSONObject(result);
//                    JSONArray list =  responseObject.getJSONArray("articles");
//                    for (int i = 0; i < list.length(); i++){
//                        JSONObject obj = list.getJSONObject(i);
//                        Student s = new Student(obj.getString("author"),obj.getString("title"),
//                                obj.getString("description"),obj.getString("url"),obj.getString("content"),
//                                obj.getString("publishedAt"));
//                        students.add(s);
//                    }
//                    showStudent(students);
//                }catch (Exception e){
//                    Log.d("ExceptionStudent", "onSuccess: " + e.getMessage());
//                }
//            }
    private ArrayList<Entry> ChartData(){
        ArrayList<Entry> dataSet = new ArrayList<>();

        dataSet.add(new Entry(0,10));
        dataSet.add(new Entry(1,20));
        return dataSet;
    }
    private ArrayList<Entry> ChartData2(){
        ArrayList<Entry> dataSet = new ArrayList<>();
        dataSet.add(new Entry(0,20));
        dataSet.add(new Entry(1,10));

        return dataSet;
    }
}
