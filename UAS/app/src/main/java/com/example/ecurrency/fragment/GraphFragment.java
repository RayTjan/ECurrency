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
import com.example.ecurrency.adapter.CurrencyArray;
import com.example.ecurrency.model.Graph;
import com.example.ecurrency.utils.ItemClickSupport;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;


public class GraphFragment extends Fragment {


    public GraphFragment() {
        // Required empty public constructor
    }

    private RecyclerView rvGraph;
    private CardGraph cardGraph;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_graph, container, false);
    }



    ArrayList<String> cnames  = new ArrayList<>();
    ArrayList<String> cMon  = new ArrayList<>();
    ArrayList<String> cCur  = new ArrayList<>();
    LineChart lineChart;
    String urlPres,urlMin ,today,days;
    Double IDR;
    ArrayList<ILineDataSet> iLineDataSets = new ArrayList<>();
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LineDataSet IDRLine = ChartDataIDR();
//        LineDataSet USDLine = ChartDataUSD();
//        LineDataSet AUDLine = ChartDataAUD();
//        LineDataSet JPYLine = ChartDataJPY();
//        LineDataSet RUBLine = ChartDataRUB();
//        LineDataSet HKDLine = ChartDataHKD();
//        LineDataSet CNYLine = ChartDataCNY();
//        LineDataSet AEDLine = ChartDataAED();
//        LineDataSet EURLine = ChartDataEUR();
//        LineDataSet CZKLine = ChartDataCZK();
//        LineDataSet DKKLine = ChartDataDKK();
//        LineDataSet SEKLine = ChartDataSEK();
//        LineDataSet PLNLine = ChartDataPLN();
//        LineDataSet TRYLine = ChartDataTRY();
//        LineDataSet UAHLine = ChartDataUAH();
        //xaxis
//        XAxis xAxis = lineChart.getXAxis();
//        xAxis.setPosition(XAxis.XAxisPosition.TOP_INSIDE);
//        xAxis.setTextSize(10f);
//        xAxis.setTextColor(Color.WHITE);
//        xAxis.setDrawAxisLine(false);
//        xAxis.setDrawGridLines(true);
//        xAxis.setTextColor(Color.rgb(255, 192, 56));
//        xAxis.setCenterAxisLabels(true);
//        xAxis.setGranularity(1f); // one hour
//        xAxis.setValueFormatter(new ValueFormatter() {
//
//            private final SimpleDateFormat mFormat = new SimpleDateFormat("dd MMM HH:mm", Locale.ENGLISH);
//
//            @Override
//            public String getFormattedValue(float value) {
//
//                long millis = TimeUnit.HOURS.toMillis((long) value);
//                return mFormat.format(new Date(millis));
//            }
//        });
        //xaxis
         lineChart = view.findViewById(R.id.over_graph);
        rvGraph = view.findViewById(R.id.rv_graph);
        cnames.add("Indonesia");
        cnames.add("America");
        cnames.add("Australia");
        cnames.add("Japan");
        cnames.add("Russia");
        cnames.add("Hongkong");
        cnames.add("China");
        cnames.add("Arabic");
        cnames.add("Europe");
        cnames.add("Czech");
        cnames.add("Danish");
        cnames.add("Sweden");
        cnames.add("Poland");
        cnames.add("Turkey");
        cnames.add("Ukraine");
        cCur.add(CurrencyArray.indonesia);
        cCur.add(CurrencyArray.america);
        cCur.add(CurrencyArray.australia);
        cCur.add(CurrencyArray.japanese);
        cCur.add(CurrencyArray.russia);
        cCur.add(CurrencyArray.hongkong);
        cCur.add(CurrencyArray.chinese);
        cCur.add(CurrencyArray.arabic);
        cCur.add(CurrencyArray.euro);
        cCur.add(CurrencyArray.czech);
        cCur.add(CurrencyArray.danish);
        cCur.add(CurrencyArray.sweden);
        cCur.add(CurrencyArray.poland);
        cCur.add(CurrencyArray.turkish);
        cCur.add(CurrencyArray.ukrainian);
        cMon.add("IDR");
        cMon.add("USD");
        cMon.add("AUD");
        cMon.add("JPY");
        cMon.add("RUB");
        cMon.add("HKD");
        cMon.add("CNY");
        cMon.add("AED");
        cMon.add("EUR");
        cMon.add("CZK");
        cMon.add("DKK");
        cMon.add("SEK");
        cMon.add("PLN");
        cMon.add("TRY");
        cMon.add("UAH");
        iLineDataSets.add(IDRLine);
        //EXAMPLE OF EDITING GRAPH
        IDRLine.setColor(Color.DKGRAY);
        IDRLine.setCircleColor(Color.DKGRAY);
        IDRLine.setLineWidth(1f);
        IDRLine.setCircleRadius(3f);
        IDRLine.setDrawCircleHole(false);
        IDRLine.setValueTextSize(9f);
        IDRLine.setDrawFilled(true);
        IDRLine.setFormLineWidth(1f);
//        iLineDataSets.add(USDLine);
//        iLineDataSets.add(AUDLine);
//        iLineDataSets.add(JPYLine);
//        iLineDataSets.add(RUBLine);
//        iLineDataSets.add(HKDLine);
//        iLineDataSets.add(CNYLine);
//        iLineDataSets.add(AEDLine);
//        iLineDataSets.add(EURLine);
//        iLineDataSets.add(CZKLine);
//        iLineDataSets.add(DKKLine);
//        iLineDataSets.add(SEKLine);
//        iLineDataSets.add(PLNLine);
//        iLineDataSets.add(TRYLine);
//        iLineDataSets.add(UAHLine);
        cardGraph = new CardGraph(getContext());
        getGraph();
        setLineChart();
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
    private void getGraph() {
        final ArrayList<Graph> graph = new ArrayList<>();


        for(int i = 0; i < cnames.size(); i++){
            Graph g = new Graph(cnames.get(i),cMon.get(i),cCur.get(i));
            Log.println(Log.INFO,"DATA RECYCERVIEW",cnames.get(i));
            graph.add(g);
        }
        showGraph(graph);
    }

    private void showGraph(final ArrayList<Graph> graph) {
        rvGraph.setLayoutManager(new LinearLayoutManager(getActivity()));
        CardGraph cardGraph = new CardGraph(getContext());
        cardGraph.setListGraph(graph);
        rvGraph.setAdapter(cardGraph);

    }




}
