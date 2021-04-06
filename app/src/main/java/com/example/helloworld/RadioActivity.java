package com.example.helloworld;

import android.widget.CheckBox;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class RadioActivity extends AppCompatActivity {
    String mess = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        Button btnCheck = findViewById(R.id.btnCheck);
        final CheckBox cbNam = findViewById(R.id.cbNam);
        final CheckBox cbNu = findViewById(R.id.cbNu);
        final CheckBox cbKhac = findViewById(R.id.cbKhac);
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(cbNam.isChecked()){
                    mess += cbNam.getText().toString() + " ";
               }
                if(cbNu.isChecked()){
                    mess += cbNu.getText().toString() + " ";
                }
                if(cbKhac.isChecked()){
                    mess += cbKhac.getText().toString() + "";
                }
                Toast.makeText(RadioActivity.this,mess, Toast.LENGTH_SHORT).show();
                mess = "";
            }
        });
    }
}