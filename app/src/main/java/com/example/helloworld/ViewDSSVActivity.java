package com.example.helloworld;

import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ViewDSSVActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_d_s_s_v);
        Bundle extras = getIntent().getExtras();

        ImageView img = findViewById(R.id.imgAa);
        img.setImageBitmap(BitmapHelper.getInstance().getBitmap());
    }
}