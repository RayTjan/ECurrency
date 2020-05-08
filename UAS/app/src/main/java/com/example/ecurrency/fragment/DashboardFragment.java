package com.example.ecurrency.fragment;


import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ecurrency.R;
import com.example.ecurrency.adapter.CardGraph;
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
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }
    LineChart lineChart;
    ArrayList<ILineDataSet> iLineDataSets = new ArrayList<>();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        rvNews = view.findViewById(R.id.rv_news);
        lineChart = view.findViewById(R.id.dash_graph);
//        LineDataSet IDRLine = ChartDataIDR();
        LineDataSet USDLine = ChartDataUSD();
        LineDataSet AUDLine = ChartDataAUD();
        LineDataSet JPYLine = ChartDataJPY();
        LineDataSet RUBLine = ChartDataRUB();
        LineDataSet HKDLine = ChartDataHKD();
        LineDataSet CNYLine = ChartDataCNY();
        LineDataSet AEDLine = ChartDataAED();
        LineDataSet EURLine = ChartDataEUR();
        LineDataSet CZKLine = ChartDataCZK();
        LineDataSet DKKLine = ChartDataDKK();
        LineDataSet SEKLine = ChartDataSEK();
        LineDataSet PLNLine = ChartDataPLN();
        LineDataSet TRYLine = ChartDataTRY();
        LineDataSet UAHLine = ChartDataUAH();

        iLineDataSets.add(USDLine);
        USDLine.setColor(Color.GREEN);
        USDLine.setCircleColor(Color.GREEN);

        iLineDataSets.add(AUDLine); //AUD
        AUDLine.setColor(Color.BLUE);
        AUDLine.setCircleColor(Color.BLUE);

        iLineDataSets.add(JPYLine);
        JPYLine.setColor(Color.LTGRAY);
        JPYLine.setCircleColor(Color.LTGRAY);

        iLineDataSets.add(RUBLine);
        AUDLine.setColor(Color.YELLOW);
        AUDLine.setCircleColor(Color.YELLOW);

        iLineDataSets.add(HKDLine);
        HKDLine.setColor(Color.CYAN);
        HKDLine.setCircleColor(Color.CYAN);

        iLineDataSets.add(CNYLine);
        CNYLine.setColor(Color.RED);
        CNYLine.setCircleColor(Color.RED);

        iLineDataSets.add(AEDLine);
        AEDLine.setColor(Color.DKGRAY);
        AEDLine.setCircleColor(Color.DKGRAY);

        iLineDataSets.add(EURLine);
        AUDLine.setColor(Color.rgb(0, 10, 90));
        AUDLine.setCircleColor(Color.rgb(0, 10, 90));

        iLineDataSets.add(CZKLine);
        AUDLine.setColor(Color.rgb(10, 50, 20));
        AUDLine.setCircleColor(Color.rgb(10, 50, 20));

        iLineDataSets.add(DKKLine);
        AUDLine.setColor(Color.rgb(60, 40, 80));
        AUDLine.setCircleColor(Color.rgb(60, 40, 80));

        iLineDataSets.add(SEKLine);
        AUDLine.setColor(Color.rgb(90, 90, 10));
        AUDLine.setCircleColor(Color.rgb(90, 90, 10));

        iLineDataSets.add(PLNLine);
        AUDLine.setColor(Color.BLACK);
        AUDLine.setCircleColor(Color.BLACK);

        iLineDataSets.add(TRYLine);
        AUDLine.setColor(Color.rgb(50, 50, 50));
        AUDLine.setCircleColor(Color.rgb(50, 50, 50));

        iLineDataSets.add(UAHLine);
        AUDLine.setColor(Color.rgb(0, 10, 10));
        AUDLine.setCircleColor(Color.rgb(0, 10, 10));

        setLineChart();
        getNews();
    }
    private LineDataSet ChartDataIDR(){
        ArrayList<Entry> dataSet = new ArrayList<>();
        for (int a=0;a<=CurrencyArray.limit;a++){
            float fill =  CurrencyArray.IDRarray.get(a).floatValue();
            dataSet.add(new Entry(a,fill ));
        }
        LineDataSet lineDataSet = new LineDataSet(dataSet  ,"IDR");
        return lineDataSet;
    }
    private LineDataSet ChartDataUSD(){
        ArrayList<Entry> dataSet = new ArrayList<>();
        for (int a=0;a<=CurrencyArray.limit;a++){
            float fill =  CurrencyArray.USDarray.get(a).floatValue();
            dataSet.add(new Entry(a,fill ));
        }
        LineDataSet lineDataSet = new LineDataSet(dataSet  ,"USD");
        return lineDataSet;
    }
    private LineDataSet ChartDataAUD(){
        ArrayList<Entry> dataSet = new ArrayList<>();
        for (int a=0;a<=CurrencyArray.limit;a++){
            float fill =  CurrencyArray.AUDarray.get(a).floatValue();
            dataSet.add(new Entry(a,fill ));
        }
        LineDataSet lineDataSet = new LineDataSet(dataSet  ,"AUD");
        return lineDataSet;

    }
    private LineDataSet ChartDataJPY(){
        ArrayList<Entry> dataSet = new ArrayList<>();
        for (int a=0;a<=CurrencyArray.limit;a++){
            float fill =  CurrencyArray.JPYarray.get(a).floatValue();
            dataSet.add(new Entry(a,fill ));
        }
        LineDataSet lineDataSet = new LineDataSet(dataSet  ,"JPY");
        return lineDataSet;

    }
    private LineDataSet ChartDataRUB(){
        ArrayList<Entry> dataSet = new ArrayList<>();
        for (int a=0;a<=CurrencyArray.limit;a++){
            float fill =  CurrencyArray.RUBarray.get(a).floatValue();
            dataSet.add(new Entry(a,fill ));
        }
        LineDataSet lineDataSet = new LineDataSet(dataSet  ,"RUB");
        return lineDataSet;

    }
    private LineDataSet ChartDataHKD(){
        ArrayList<Entry> dataSet = new ArrayList<>();
        for (int a=0;a<=CurrencyArray.limit;a++){
            float fill =  CurrencyArray.HKDarray.get(a).floatValue();
            dataSet.add(new Entry(a,fill ));
        }
        LineDataSet lineDataSet = new LineDataSet(dataSet  ,"HKD");
        return lineDataSet;

    }
    private LineDataSet ChartDataCNY(){
        ArrayList<Entry> dataSet = new ArrayList<>();
        for (int a=0;a<=CurrencyArray.limit;a++){
            float fill =  CurrencyArray.CNYarray.get(a).floatValue();
            dataSet.add(new Entry(a,fill ));
        }
        LineDataSet lineDataSet = new LineDataSet(dataSet  ,"CNY");
        return lineDataSet;

    }
    private LineDataSet ChartDataAED(){
        ArrayList<Entry> dataSet = new ArrayList<>();
        for (int a=0;a<=CurrencyArray.limit;a++){
            float fill =  CurrencyArray.AEDarray.get(a).floatValue();
            dataSet.add(new Entry(a,fill ));
        }
        LineDataSet lineDataSet = new LineDataSet(dataSet  ,"AED");
        return lineDataSet;

    }
    private LineDataSet ChartDataEUR(){
        ArrayList<Entry> dataSet = new ArrayList<>();
        for (int a=0;a<=CurrencyArray.limit;a++){
            float fill =  CurrencyArray.EURarray.get(a).floatValue();
            dataSet.add(new Entry(a,fill ));
        }
        LineDataSet lineDataSet = new LineDataSet(dataSet  ,"EUR");
        return lineDataSet;

    }
    private LineDataSet ChartDataCZK(){
        ArrayList<Entry> dataSet = new ArrayList<>();
        for (int a=0;a<=CurrencyArray.limit;a++){
            float fill =  CurrencyArray.CZKarray.get(a).floatValue();
            dataSet.add(new Entry(a,fill ));
        }
        LineDataSet lineDataSet = new LineDataSet(dataSet  ,"CZK");
        return lineDataSet;

    }
    private LineDataSet ChartDataDKK(){
        ArrayList<Entry> dataSet = new ArrayList<>();
        for (int a=0;a<=CurrencyArray.limit;a++){
            float fill =  CurrencyArray.DKKarray.get(a).floatValue();
            dataSet.add(new Entry(a,fill ));
        }
        LineDataSet lineDataSet = new LineDataSet(dataSet  ,"DKK");
        return lineDataSet;

    }
    private LineDataSet ChartDataSEK(){
        ArrayList<Entry> dataSet = new ArrayList<>();
        for (int a=0;a<=CurrencyArray.limit;a++){
            float fill =  CurrencyArray.SEKarray.get(a).floatValue();
            dataSet.add(new Entry(a,fill ));
        }
        LineDataSet lineDataSet = new LineDataSet(dataSet  ,"SEK");
        return lineDataSet;

    }
    private LineDataSet ChartDataPLN(){
        ArrayList<Entry> dataSet = new ArrayList<>();
        for (int a=0;a<=CurrencyArray.limit;a++){
            float fill =  CurrencyArray.PLNarray.get(a).floatValue();
            dataSet.add(new Entry(a,fill ));
        }
        LineDataSet lineDataSet = new LineDataSet(dataSet  ,"PLN");
        return lineDataSet;

    }
    private LineDataSet ChartDataTRY(){
        ArrayList<Entry> dataSet = new ArrayList<>();
        for (int a=0;a<=CurrencyArray.limit;a++){
            float fill =  CurrencyArray.TRYarray.get(a).floatValue();
            dataSet.add(new Entry(a,fill ));
        }
        LineDataSet lineDataSet = new LineDataSet(dataSet  ,"TRY");
        return lineDataSet;

    }
    private LineDataSet ChartDataUAH(){
        ArrayList<Entry> dataSet = new ArrayList<>();
        for (int a=0;a<=CurrencyArray.limit;a++){
            float fill =  CurrencyArray.UAHarray.get(a).floatValue();
            dataSet.add(new Entry(a,fill ));
        }
        LineDataSet lineDataSet = new LineDataSet(dataSet  ,"UAH");
        return lineDataSet;

    }
    public void setLineChart(){

//        iLineDataSets.add(lineDataSet);
//        iLineDataSets.remove(lineDataSet);
//        iLineDataSets.add(lineDataSet2);

        LineData lineData = new LineData(iLineDataSets);
        lineChart.setData(lineData);
        lineChart.invalidate();

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
