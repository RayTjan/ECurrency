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
import com.example.ecurrency.adapter.CurrencyArray;
import com.google.android.material.textfield.TextInputLayout;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalculatorFragment extends Fragment implements AdapterView.OnItemSelectedListener {
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
        if (currency.equalsIgnoreCase("IDR")){
            return Double.parseDouble(CurrencyArray.indonesia);
        }
        else if (currency.equalsIgnoreCase("USD")){
            return Double.parseDouble(CurrencyArray.america);
        }
        else if (currency.equalsIgnoreCase("AUD")){
            return Double.parseDouble(CurrencyArray.australia);

        }
        else if (currency.equalsIgnoreCase("JPY")){
            return Double.parseDouble(CurrencyArray.japanese);

        }
        else if (currency.equalsIgnoreCase("RUB")){
            return Double.parseDouble(CurrencyArray.russia);

        }
        else if (currency.equalsIgnoreCase("HKD")){
            return Double.parseDouble(CurrencyArray.hongkong);

        }
        else if (currency.equalsIgnoreCase("CNY")){
            return Double.parseDouble(CurrencyArray.chinese);

        }else if (currency.equalsIgnoreCase("AED")){
            return Double.parseDouble(CurrencyArray.arabic);

        }else if (currency.equalsIgnoreCase("EUR")){
            return Double.parseDouble(CurrencyArray.euro);

        }
        else if (currency.equalsIgnoreCase("CZK")){
            return Double.parseDouble(CurrencyArray.czech);
        }else if (currency.equalsIgnoreCase("DKK")){
            return Double.parseDouble(CurrencyArray.danish);

        }else if (currency.equalsIgnoreCase("SEK")){
            return Double.parseDouble(CurrencyArray.sweden);

        }else if (currency.equalsIgnoreCase("PLN")){
            return Double.parseDouble(CurrencyArray.poland);

        }else if (currency.equalsIgnoreCase("TRY")){
            return Double.parseDouble(CurrencyArray.turkish);

        }        else{
            return Double.parseDouble(CurrencyArray.ukrainian);
        }

    }

}
