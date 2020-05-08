package com.example.ecurrency.adapter;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import cz.msebera.android.httpclient.Header;

public class CurrencyArray {
    public static ArrayList<Double> IDRarray = new ArrayList<>();
    public static ArrayList<Double> USDarray = new ArrayList<>();
    public static ArrayList<Double> AUDarray = new ArrayList<>();
    public static ArrayList<Double> JPYarray = new ArrayList<>();
    public static ArrayList<Double> RUBarray = new ArrayList<>();
    public static ArrayList<Double> HKDarray = new ArrayList<>();
    public static ArrayList<Double> CNYarray = new ArrayList<>();
    public static ArrayList<Double> AEDarray = new ArrayList<>();
    public static ArrayList<Double> EURarray = new ArrayList<>();
    public static ArrayList<Double> CZKarray = new ArrayList<>();
    public static ArrayList<Double> DKKarray = new ArrayList<>();
    public static ArrayList<Double> SEKarray = new ArrayList<>();
    public static ArrayList<Double> PLNarray = new ArrayList<>();
    public static ArrayList<Double> TRYarray = new ArrayList<>();
    public static ArrayList<Double> UAHarray = new ArrayList<>();
    public static String indonesia, america, australia, japanese, russia, hongkong, chinese, arabic, euro, czech, danish, sweden, poland, turkish, ukrainian;
    public static int limit = 5;
    public static Double IDR,USD,AUD,JPY,RUB,HKD,CNY,AED,EUR,CZK,DKK,SEK,PLN,TRY,UAH;
    private static String urlPres,urlMin ,today,days,months;

    public ArrayList<Double> getIDRarray() {
        return IDRarray;
    }


    public static void SetIDRFirst(){
        Log.println(Log.INFO,"STARTING TO FILL","START SETIDRFIRST");
        urlPres = "http://data.fixer.io/api/latest?access_key=26f7bb08aa05dfa29d72169517d9ceef";

        getIDR(urlPres);
        today = date();
        for (int a=1;a<=CurrencyArray.limit;a++){
            int month = Integer.parseInt(today.substring(today.length()-5,today.length()-3)) -a;
            int day = Integer.parseInt(today.substring(today.length()-2,today.length())) -a;
            String dayStr = String.valueOf(day);
            if( day<10){
                dayStr = new StringBuffer(dayStr).insert(0,"0").toString();;
            }
            days = new StringBuffer(today).replace(today.length()-2,today.length(),dayStr).toString();
            months = new StringBuffer(today).replace(today.length()-5,today.length()-3,dayStr).toString();
            urlMin = new StringBuffer(urlPres).replace(urlPres.length()-50,urlPres.length()-44,days).toString();
            Log.println(  Log.INFO ,"DATE IS HEREE",urlMin);
            getIDR(urlMin);
            Log.println(Log.INFO,"ARRAY RESULT","Probablt loadnig");
        }
    }
    public static void getIDR(String link){
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(link, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try{
                    String result = new String (responseBody);
                    JSONObject responseObject = new JSONObject(result);
                    JSONObject rates = responseObject.getJSONObject("rates");
                    IDR = rates.getDouble("IDR");
                    IDRarray.add(IDR);
                    USD = rates.getDouble("USD");
                    USDarray.add(USD);
                    AUD = rates.getDouble("AUD");
                    AUDarray.add(AUD);
                    JPY = rates.getDouble("JPY");
                    JPYarray.add(JPY);
                    RUB = rates.getDouble("RUB");
                    RUBarray.add(RUB);
                    HKD = rates.getDouble("HKD");
                    HKDarray.add(HKD);
                    CNY = rates.getDouble("CNY");
                    CNYarray.add(CNY);
                    AED = rates.getDouble("AED");
                    AEDarray.add(AED);
                    EUR = rates.getDouble("EUR");
                    EURarray.add(EUR);
                    CZK = rates.getDouble("CZK");
                    CZKarray.add(CZK);
                    DKK= rates.getDouble("DKK");
                    DKKarray.add(DKK);
                    SEK = rates.getDouble("SEK");
                    SEKarray.add(SEK);
                    PLN = rates.getDouble("PLN");
                    PLNarray.add(PLN);
                    TRY = rates.getDouble("TRY");
                    TRYarray.add(TRY);
                    UAH = rates.getDouble("UAH");
                    UAHarray.add(UAH);
                    Log.println(Log.INFO,"INDONESIA SETTWOOOOO",IDR.toString());
                }catch (Exception e){
                    Log.d("ExceptionStudent", "onSuccess: " + e.getMessage());
                } // Completed the request (either success or failure)
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("FAILED", "FAIL");
            }
        });
    }
    public static void getCurrency(String link){
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

                    indonesia = String.format("%.2f", IDR);
                    america =String.format("%.2f", USD);
                    australia = String.format("%.2f", AUD);
                    japanese = String.format("%.2f", JPY);
                    russia = String.format("%.2f", RUB);
                    hongkong = String.format("%.2f", HKD);
                    chinese =String.format("%.2f", CNY);
                    arabic = String.format("%.2f", AED);
                    euro = String.format("%.2f", EUR);
                    czech = String.format("%.2f", CZK);
                    danish = String.format("%.2f", DKK);
                    sweden = String.format("%.2f", SEK);
                    poland = String.format("%.2f", PLN);
                    turkish = String.format("%.2f", TRY);
                    ukrainian = String.format("%.2f", UAH);

                }catch (Exception e){
                    Log.d("ExceptionStudent", "onSuccess: " + e.getMessage());
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }
    public static String date() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date curDate = new Date(System.currentTimeMillis());
        String str = formatter.format(curDate);
        return str;
    }
}
