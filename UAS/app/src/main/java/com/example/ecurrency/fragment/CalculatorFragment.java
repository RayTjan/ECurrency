package com.example.ecurrency.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecurrency.R;
import com.google.android.material.textfield.TextInputLayout;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalculatorFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    Double indonesia, america, australia, japanese, russia, hongkong, chinese, arabic, euro, czech, danish, sweden, poland, turkish, ukrainian;
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
        return inflater.inflate(R.layout.fragment_calculator, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        View view = inflater.inflate(R.layout.fragment_calculator, container, false);
        getCurrency();
        resultCal = view.findViewById(R.id.calOutput) ;
        inputCal = view.findViewById(R.id.calInput);
        convert = view.findViewById(R.id.convert);
        spinner1 = view.findViewById(R.id.reminder_spinner_currency);
        spinner1.setOnItemSelectedListener(CalculatorFragment.this);
        spinner2 = view.findViewById(R.id.spinner2);
        spinner2.setOnItemSelectedListener(CalculatorFragment.this);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultDouble= (Double.parseDouble(inputCal.getEditText().getText().toString()) /getRatio(spinner1.getSelectedItem().toString()))*getRatio(spinner2.getSelectedItem().toString());
                resultCal.setText(Double.toString(resultDouble));
            }
        });

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public double getRatio( String currency){
        getCurrency();
        if (currency.equalsIgnoreCase("IDR")){
//            return Double.parseDouble(indonesia);
            return indonesia;
        }
        else if (currency.equalsIgnoreCase("USD")){
//            return Double.parseDouble(america);
            return america;
        }
        else if (currency.equalsIgnoreCase("AUD")){
//            return Double.parseDouble(australia);
            return australia;

        }
        else if (currency.equalsIgnoreCase("JPY")){
//            return Double.parseDouble(japanese);
            return japanese;

        }
        else if (currency.equalsIgnoreCase("RUB")){
//            return Double.parseDouble(russia);
            return russia;

        }
        else if (currency.equalsIgnoreCase("HKD")){
//            return Double.parseDouble(hongkong);
            return hongkong;

        }
        else if (currency.equalsIgnoreCase("CNY")){
//            return Double.parseDouble(chinese);
            return chinese;

        }else if (currency.equalsIgnoreCase("AED")){
//            return Double.parseDouble(arabic);
            return arabic;

        }else if (currency.equalsIgnoreCase("EUR")){
//            return Double.parseDouble(euro);
            return euro;

        }
        else if (currency.equalsIgnoreCase("CZK")){
//            return Double.parseDouble(czech);
            return czech;


        }else if (currency.equalsIgnoreCase("DKK")){
//            return Double.parseDouble(danish);
            return danish;

        }else if (currency.equalsIgnoreCase("SEK")){
//            return Double.parseDouble(sweden);
            return sweden;

        }else if (currency.equalsIgnoreCase("PLN")){
//            return Double.parseDouble(poland);
            return poland;

        }else if (currency.equalsIgnoreCase("TRY")){
//            return Double.parseDouble(turkish);
            return turkish;

        }        else{
//            return Double.parseDouble(ukrainian);
            return ukrainian;
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

//                    indonesia = Double.toString(IDR);
//                    america = Double.toString(USD);
//                    australia = Double.toString(AUD);
//                    japanese = Double.toString(JPY);
//                    russia = Double.toString(RUB);
//                    hongkong = Double.toString(HKD);
//                    chinese = Double.toString(CNY);
//                    arabic = Double.toString(AED);
//                    euro = Double.toString(EUR);
//                    czech = Double.toString(CZK);
//                    danish = Double.toString(DKK);
//                    sweden = Double.toString(SEK);
//                    poland = Double.toString(PLN);
//                    turkish = Double.toString(TRY);
//                    ukrainian = Double.toString(UAH);

                    indonesia = IDR;
                    america = USD;
                    australia = AUD;
                    japanese = JPY;
                    russia = RUB;
                    hongkong = HKD;
                    chinese = CNY;
                    arabic = AED;
                    euro = EUR;
                    czech = CZK;
                    danish = DKK;
                    sweden = SEK;
                    poland = PLN;
                    turkish = TRY;
                    ukrainian = UAH;

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
