package com.example.helloworld;

import android.content.Context;
import android.util.Log;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class IntentInDs2 extends AppCompatActivity {

    private ListView lsUs;
    private ArrayList<String> listUs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_in_ds2);

        getViews();
        Bundle extras = getIntent().getExtras();
        listUs = extras.getStringArrayList("arrayUs");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(IntentInDs2.this,R.layout.item_layout,R.id.twInfo, listUs);
        lsUs.setAdapter(arrayAdapter);


    }

    void getViews() {
        lsUs = findViewById(R.id.lwUs);
    }
}