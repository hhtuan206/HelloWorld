package com.example.helloworld;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class GPTBNActivity extends AppCompatActivity {
    private Button btnXoa;
    private Button btnGiai;
    private EditText editA;
    private EditText editB;
    private TextView txtView;
    private Double kq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g_p_t_b_n);
        getView();

        btnGiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kq = -convertDouble(editB)/convertDouble(editA);
                txtView.setText("Phương trình có nghiệm "+kq.toString());
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editA.setText("");
                editB.setText("");
                txtView.setText("");
            }
        });
    }

    void getView() {
         btnXoa = findViewById(R.id.btnXoa);
         btnGiai = findViewById(R.id.btnGiai);
         editA = findViewById(R.id.editA);
         editB = findViewById(R.id.editB);
         txtView = findViewById(R.id.txtView);
    }

    Double convertDouble(EditText number) {
        
        return Double.parseDouble(number.getText().toString()
        );
    }
}