package com.example.ecurrency.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.ecurrency.R;
import com.example.ecurrency.model.Graph;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_STUDENT = "extra";
    private Graph graph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if(getIntent().getParcelableExtra(EXTRA_STUDENT) != null){
            graph = getIntent().getParcelableExtra(EXTRA_STUDENT);
        }

        Toast.makeText(this, graph.getState(), Toast.LENGTH_SHORT).show();
    }
}
