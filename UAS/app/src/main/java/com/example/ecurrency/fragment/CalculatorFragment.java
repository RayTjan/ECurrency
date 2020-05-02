package com.example.ecurrency.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ecurrency.MainActivity;
import com.example.ecurrency.R;
import com.example.ecurrency.SplashScreenActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalculatorFragment extends Fragment implements AdapterView.OnItemSelectedListener {


    public CalculatorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);
        Spinner spinner = (Spinner)container.findViewById(R.id.spinner1);
        spinner.setOnItemSelectedListener(CalculatorFragment.this);
        return inflater.inflate(R.layout.fragment_calculator, container, false);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
