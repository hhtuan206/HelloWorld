package com.example.helloworld;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class IntentInDSActivity extends AppCompatActivity {

    private Button btnAdd;
    private Button btnPrint;
    private EditText editName;
    private EditText editAddress;
    private RadioButton rbNam;
    private RadioButton rbNu;
    private String sex;
    private ArrayList<String> listUs = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_in_d_s);

        getViews();
        CompoundButton.OnCheckedChangeListener listenerRadio = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    sex = buttonView.getText().toString();
                }
            }
        };
        rbNam.setOnCheckedChangeListener(listenerRadio);
        rbNu.setOnCheckedChangeListener(listenerRadio);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String us = editName.getText().toString() + " - " + sex + " - " + editAddress.getText().toString();
                listUs.add(us);
                Toast.makeText(IntentInDSActivity.this, editName.getText().toString(), Toast.LENGTH_SHORT).show();
                clean();
            }
        });

        btnPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntentInDSActivity.this, IntentInDs2.class);
                intent.putExtra("arrayUs", listUs);
                startActivity(intent);
            }
        });


    }

    void getViews() {
        btnAdd = findViewById(R.id.btnAdd);
        btnPrint = findViewById(R.id.btnPrint);
        editName = findViewById(R.id.editName);
        editAddress = findViewById(R.id.editAddress);
        rbNam = findViewById(R.id.cbNu);
        rbNu = findViewById(R.id.cbNam);
    }

    void clean() {
        editName.setText("");
        editAddress.setText("");
    }


}