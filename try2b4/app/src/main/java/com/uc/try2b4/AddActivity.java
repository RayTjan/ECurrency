package com.uc.try2b4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class AddActivity extends AppCompatActivity {
    TextInputLayout detail1,detail2,detail3;
    Button submit;
    String Detail1,Detail2,Detail3;
    Toolbar back;
    array itemlist1 = new array();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        final LoadingDialog loadingDialog = new LoadingDialog(AddActivity.this);
        //initializing the design variables
        detail1 = findViewById(R.id.add_inputS_detail1);
        detail2 = findViewById(R.id.add_inputS_detail2);
        detail3 = findViewById(R.id.add_inputS_detail3);
        submit = findViewById(R.id.add_button_view);
        back = findViewById(R.id.add_toolbar);
        //textwatcher
        detail1.getEditText().addTextChangedListener(inputCheck);
        detail2.getEditText().addTextChangedListener(inputCheck);
        detail3.getEditText().addTextChangedListener(inputCheck);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingDialog.startLoadingDialog();

                ArrayList<items> itemlist = new ArrayList<>();
                Intent viewRes = new Intent(AddActivity.this, MainActivity.class);
                itemlist1 = getIntent().getParcelableExtra(transfer);
                if (getIntent().getParcelableExtra(transfer)!=null){
                    itemlist = itemlist1.getItemlist();
                }

                items me = new items(Detail1,Detail2 + " years old",Detail3,R.drawable.face,R.drawable.location);
                itemlist.add(me);
                if (!itemlist.isEmpty()){
                    itemlist1.setItemlist( itemlist);
                    itemlist1 = getIntent().getParcelableExtra(transfer);
                    viewRes.putExtra(MainActivity.transfer1, itemlist1);
                }

                startActivity(viewRes);
                finish();

            }
        });

        //backbutton
        back.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<items> itemlist = new ArrayList<>();
                itemlist1 = getIntent().getParcelableExtra(transfer);

                Intent previous = new Intent(AddActivity.this, MainActivity.class);
                previous.putExtra(MainActivity.transfer1, itemlist1);
                startActivity(previous);
                finish();
            }
        });




    }
    TextWatcher inputCheck = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            Detail1 = detail1.getEditText().getText().toString().trim();
            Detail2 = detail2.getEditText().getText().toString().trim();
            Detail3 = detail3.getEditText().getText().toString().trim();
            submit.setEnabled(!Detail1.isEmpty() && !Detail2.isEmpty() && !Detail3.isEmpty() );
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    public static final String transfer = "what";

}
