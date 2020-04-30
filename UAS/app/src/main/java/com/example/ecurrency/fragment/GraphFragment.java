package com.example.ecurrency.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ecurrency.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;


public class GraphFragment extends Fragment {


    public GraphFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_graph, container, false);
    }

    String indonesia, america, australia, japanese, russia, hongkong, chinese, arabic, euro, czech, danish, sweden, poland, turkish, ukrainian;

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
