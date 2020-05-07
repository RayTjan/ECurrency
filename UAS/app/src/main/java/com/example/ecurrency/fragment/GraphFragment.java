package com.example.ecurrency.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecurrency.R;
import com.example.ecurrency.activities.DetailActivity;
import com.example.ecurrency.adapter.CardGraph;
import com.example.ecurrency.adapter.idrArray;
import com.example.ecurrency.model.Graph;
import com.example.ecurrency.utils.ItemClickSupport;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

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

    String indonesia, america, australia, japanese, russia, hongkong, chinese, arabic, euro, czech, danish, sweden, poland, turkish, ukrainian;


    ArrayList<String> cnames  = new ArrayList<>();
    ArrayList<String> cMon  = new ArrayList<>();
    ArrayList<String> cCur  = new ArrayList<>();
    LineChart lineChart;
    String urlPres,urlMin ,today,days;
    Double IDR;

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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
        getCurrency("http://data.fixer.io/api/latest?access_key=ac31820a29489ce18b9208b5c5c5d557");
         lineChart = view.findViewById(R.id.over_graph);
        ChartData();
        rvGraph = view.findViewById(R.id.rv_graph);
        cardGraph = new CardGraph(getContext());
        getGraph();
    }

    private void ChartData(){
        ArrayList<Entry> dataSet = new ArrayList<>();
        for (int a=0;a<=5;a++){
            float fill =  idrArray.IDRarray.get(a).floatValue();
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
        lineChart.setBackgroundColor(Color.YELLOW);
    }
    private void getGraph() {
        final ArrayList<Graph> graph = new ArrayList<>();
        cnames.add("indonesia");
        cnames.add("america");
        cnames.add("australia");
        cnames.add("japanese");
        cnames.add("russia");
        cnames.add("hongkong");
        cnames.add("chinese");
        cnames.add("arabic");
        cnames.add("euro");
        cnames.add("czech");
        cnames.add("danish");
        cnames.add("sweden");
        cnames.add("poland");
        cnames.add("turkish");
        cnames.add("ukrainian");
        cCur.add(indonesia);
        cCur.add(america);
        cCur.add(australia);
        cCur.add(japanese);
        cCur.add(russia);
        cCur.add(hongkong);
        cCur.add(chinese);
        cCur.add(arabic);
        cCur.add(euro);
        cCur.add(czech);
        cCur.add(danish);
        cCur.add(sweden);
        cCur.add(poland);
        cCur.add(turkish);
        cCur.add(ukrainian);
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

        for(int i = 0; i < cnames.size(); i++){
            Graph g = new Graph(cnames.get(i),cMon.get(i),cCur.get(i));
            graph.add(g);
        }
        showGraph(graph);
    }

    private void showGraph(final ArrayList<Graph> graph) {
        rvGraph.setLayoutManager(new LinearLayoutManager(getActivity()));
        CardGraph cardGraph = new CardGraph(getContext());
        cardGraph.setListGraph(graph);
        rvGraph.setAdapter(cardGraph);
//        ItemClickSupport.addTo(rvGraph).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
//            @Override
//            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
//                Intent intent = new Intent(getActivity(), DetailActivity.class);
//                intent.putExtra(DetailActivity.EXTRA_STUDENT, (Parcelable) graph.get(position));
//                startActivity(intent);
//                Toast.makeText(getContext(), graph.get(position).getState(), Toast.LENGTH_SHORT).show();
//            }
//        });

    }


    public void getCurrency(String link){
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(link, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try{
                    String result = new String (responseBody);
                    JSONObject responseObject = new JSONObject(result);
                    JSONObject rates = responseObject.getJSONObject("rates");
                    Double IDR = rates.getDouble("IDR");
                    Double USD = rates.getDouble("USD");
                    Double AUD = rates.getDouble("AUD");
                    Double JPY = rates.getDouble("JPY");
                    Double RUB = rates.getDouble("RUB");
                    Double HKD = rates.getDouble("HKD");
                    Double CNY = rates.getDouble("CNY");
                    Double AED = rates.getDouble("AED");
                    Double EUR = rates.getDouble("EUR");
                    Double CZK = rates.getDouble("CZK");
                    Double DKK = rates.getDouble("DKK");
                    Double SEK = rates.getDouble("SEK");
                    Double PLN = rates.getDouble("PLN");
                    Double TRY = rates.getDouble("TRY");
                    Double UAH = rates.getDouble("UAH");

                    indonesia = Double.toString(IDR);
                    america = Double.toString(USD);
                    australia = Double.toString(AUD);
                    japanese = Double.toString(JPY);
                    russia = Double.toString(RUB);
                    hongkong = Double.toString(HKD);
                    chinese = Double.toString(CNY);
                    arabic = Double.toString(AED);
                    euro = Double.toString(EUR);
                    czech = Double.toString(CZK);
                    danish = Double.toString(DKK);
                    sweden = Double.toString(SEK);
                    poland = Double.toString(PLN);
                    turkish = Double.toString(TRY);
                    ukrainian = Double.toString(UAH);

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
