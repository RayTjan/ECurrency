package com.example.ecurrency.fragment;


import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ecurrency.R;
import com.example.ecurrency.adapter.CardNews;
import com.example.ecurrency.adapter.CurrencyArray;
import com.example.ecurrency.model.News;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;


public class DashboardFragment extends Fragment {


    public DashboardFragment() {

    }

    private RecyclerView rvNews;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        Button btnFragment = (Button)view.findViewById(R.id.btnToNews);
        btnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new Fragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_frame, new NewsFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        Button btnFragment2 = (Button)view.findViewById(R.id.btnToCalc);
        btnFragment2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Fragment fragment = new Fragment();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.main_frame, new NewsFragment());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        });
        return view;
    }
    LineChart lineChart;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        rvNews = view.findViewById(R.id.rv_news);
        lineChart = view.findViewById(R.id.dash_graph);
        ChartData();
        getNews();
    }
    private LineDataSet ChartDataUSD(){
        ArrayList<Entry> dataSet = new ArrayList<>();
        for (int a=0;a<=5;a++){
            float fill =  CurrencyArray.USDarray.get(a).floatValue();
            dataSet.add(new Entry(a,fill ));
        }
        LineDataSet lineDataSet = new LineDataSet(dataSet  ,"USD");
        return lineDataSet;

    }
    private LineDataSet ChartDataAUD(){
        ArrayList<Entry> dataSet = new ArrayList<>();
        for (int a=0;a<=5;a++){
            float fill =  CurrencyArray.AUDarray.get(a).floatValue();
            dataSet.add(new Entry(a,fill ));
        }
        LineDataSet lineDataSet = new LineDataSet(dataSet  ,"AUD");
        return lineDataSet;

    }
    private LineDataSet ChartDataJPY(){
        ArrayList<Entry> dataSet = new ArrayList<>();
        for (int a=0;a<=3;a++){
            float fill =  CurrencyArray.JPYarray.get(a).floatValue();
            dataSet.add(new Entry(a,fill ));
        }
        LineDataSet lineDataSet = new LineDataSet(dataSet  ,"JPY");
        return lineDataSet;

    }
    private LineDataSet ChartDataRUB(){
        ArrayList<Entry> dataSet = new ArrayList<>();
        for (int a=0;a<=5;a++){
            float fill =  CurrencyArray.RUBarray.get(a).floatValue();
            dataSet.add(new Entry(a,fill ));
        }
        LineDataSet lineDataSet = new LineDataSet(dataSet  ,"RUB");
        return lineDataSet;

    }
    private LineDataSet ChartDataHKD(){
        ArrayList<Entry> dataSet = new ArrayList<>();
        for (int a=0;a<=5;a++){
            float fill =  CurrencyArray.HKDarray.get(a).floatValue();
            dataSet.add(new Entry(a,fill ));
        }
        LineDataSet lineDataSet = new LineDataSet(dataSet  ,"HKD");
        return lineDataSet;

    }
    private LineDataSet ChartDataCNY(){
    private void ChartData(){
        ArrayList<Entry> dataSet = new ArrayList<>();
        for (int a=0;a<=5;a++){
            float fill =  CurrencyArray.IDRarray.get(a).floatValue();
            dataSet.add(new Entry(a,fill ));
        }
        showChart(dataSet);
    }

    public void showChart(ArrayList<Entry> data){
        LineDataSet lineDataSet = new LineDataSet(data  ,"IDR");
//        LineDataSet lineDataSet2 = new LineDataSet(ChartData2(),"data2 set");
        ArrayList<ILineDataSet> iLineDataSets = new ArrayList<>();
        iLineDataSets.add(lineDataSet);
//        iLineDataSets.add(lineDataSet2);

        LineData lineData = new LineData(iLineDataSets);
        lineChart.setData(lineData);
        lineChart.invalidate();
//        lineDataSet.enableDashedLine(10f, 5f, 0f);
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
        lineChart.setBackgroundColor(Color.WHITE);
    }
    public void getNews(){
        final ArrayList<News> News = new ArrayList<>();
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://newsapi.org/v2/top-headlines?category=business&apiKey=e692335ecadf4fa881abc2d91d9d83c1";

        client.get(url, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try{
                    String result = new String (responseBody);
                    JSONObject responseObject = new JSONObject(result);
                    JSONArray list =  responseObject.getJSONArray("articles");
                    for (int i = 0; i < list.length(); i++){
                        JSONObject obj = list.getJSONObject(i);
                        News s = new News(obj.getString("title"), obj.getString("description"),obj.getString("urlToImage"));
                        News.add(s);
                    }
                    showNews(News);
                }catch (Exception e){
                    Log.d("ExceptionStudent", "onSuccess: " + e.getMessage());
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("OnFailureStudent", "onFailure: " + error.getMessage());
            }
        });
    }

    private void showNews(ArrayList<News> news) {
        rvNews.setLayoutManager(new LinearLayoutManager(getActivity()));
        CardNews cardNews = new CardNews(getContext());
        cardNews.setListNews(news);
        rvNews.setAdapter(cardNews);
    }
}
