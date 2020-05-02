package com.example.ecurrency.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecurrency.MainActivity;
import com.example.ecurrency.R;
import com.example.ecurrency.SplashScreenActivity;
import com.google.android.material.textfield.TextInputLayout;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalculatorFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    String indonesia, america, australia, japanese, russia, hongkong, chinese, arabic, euro, czech, danish, sweden, poland, turkish, ukrainian;
    TextView resultCal;
    TextInputLayout inputCal;
    Spinner spinner1,spinner2;
    Double resultDouble;
    Button convert;
    public CalculatorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);
        getCurrency();
        resultCal = (TextView)view.findViewById(R.id.calOutput) ;
        inputCal = (TextInputLayout)view.findViewById(R.id.calInput);
        convert = (Button)view.findViewById(R.id.convert);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("WORKING!!!");
                resultDouble= (Double.parseDouble(inputCal.getEditText().getText().toString()) /getRatio(spinner1.getSelectedItem().toString()))*getRatio(spinner2.getSelectedItem().toString());
                resultCal.setText(Double.toString(resultDouble));
            }
        });
        spinner1 = (Spinner)view.findViewById(R.id.spinner1);
//        spinner1.setOnItemSelectedListener(CalculatorFragment.this);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("WORKING!!!");

                resultDouble= (Double.parseDouble(inputCal.getEditText().getText().toString()) /getRatio(spinner1.getSelectedItem().toString()))*getRatio(spinner2.getSelectedItem().toString());
                    resultCal.setText(Double.toString(resultDouble));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner2 = (Spinner)view.findViewById(R.id.spinner2);
//        spinner1.setOnItemSelectedListener(CalculatorFragment.this);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("WORKING!!!");

                resultDouble= (Double.parseDouble(inputCal.getEditText().getText().toString()) /getRatio(spinner1.getSelectedItem().toString()))*getRatio(spinner2.getSelectedItem().toString());
                resultCal.setText(Double.toString(resultDouble));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        inputCal.getEditText().addTextChangedListener(inputcheck);


        return inflater.inflate(R.layout.fragment_calculator, container, false);
    }
    TextWatcher inputcheck = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            resultDouble= (Double.parseDouble(inputCal.getEditText().getText().toString()) /getRatio(spinner1.getSelectedItem().toString()))*getRatio(spinner2.getSelectedItem().toString());
            resultCal.setText(Double.toString(resultDouble));
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void calculate(){

    }
    public double getRatio( String currency){

        if (currency.equalsIgnoreCase("IDR")){
            return Double.parseDouble(indonesia);
        }
        else if (currency.equalsIgnoreCase("USD")){
            return Double.parseDouble(america);
        }
        else if (currency.equalsIgnoreCase("AUD")){
            return Double.parseDouble(australia);
        }
        else if (currency.equalsIgnoreCase("JPY")){
            return Double.parseDouble(japanese);

        }
        else if (currency.equalsIgnoreCase("RUB")){
            return Double.parseDouble(russia);

        }
        else if (currency.equalsIgnoreCase("HKD")){
            return Double.parseDouble(hongkong);

        }
        else if (currency.equalsIgnoreCase("CNY")){
            return Double.parseDouble(chinese);

        }else if (currency.equalsIgnoreCase("AED")){
            return Double.parseDouble(arabic);

        }else if (currency.equalsIgnoreCase("EUR")){
            return Double.parseDouble(euro);

        }
        else if (currency.equalsIgnoreCase("CZK")){
            return Double.parseDouble(czech);

        }else if (currency.equalsIgnoreCase("DKK")){
            return Double.parseDouble(danish);

        }else if (currency.equalsIgnoreCase("SEK")){
            return Double.parseDouble(sweden);

        }else if (currency.equalsIgnoreCase("PLN")){
            return Double.parseDouble(poland);

        }else if (currency.equalsIgnoreCase("TRY")){
            return Double.parseDouble(turkish);

        }        else{
            return Double.parseDouble(ukrainian);

        }

        }

    public void getCurrency(){
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
