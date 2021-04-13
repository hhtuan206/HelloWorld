package com.example.helloworld;

import android.Manifest;
import android.content.Intent;

import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class DssvActivity extends AppCompatActivity {
    Button btnPickImg;
    ImageView imgAva;
    Button btnXem;
    EditText edtName;
    EditText edtDesc;
    private RadioButton rbNam;
    private RadioButton rbNu;
    String sex;
    Bitmap bm;
    String name;
    String desc;
    private static final int IMAGE_PICK_CODE = 1000;
    private static final int PERMISSION_CODE = 1001;
    String urlImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dssv);
        getView();
        getEdit();
        event();
    }

    void getView() {
        btnPickImg = findViewById(R.id.btnPickImg);
        imgAva = findViewById(R.id.imgAva);
        btnXem = findViewById(R.id.btnXem);
        edtName = findViewById(R.id.editName);
        edtDesc = findViewById(R.id.editDesc);
    }

    void event() {
        btnPickImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == getPackageManager().PERMISSION_DENIED) {
//                    String[] permission = {Manifest.permission.READ_EXTERNAL_STORAGE};
//                    requestPermissions(permission, PERMISSION_CODE);
//                } else {
//                    pickImageFromGallery();
//                }
                pickImageFromGallery();
            }
        });

        btnXem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passData();
            }
        });

//        CompoundButton.OnCheckedChangeListener listenerRadio = new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    sex = buttonView.getText().toString();
//                }
//            }
//        };
//        rbNam.setOnCheckedChangeListener(listenerRadio);
//        rbNu.setOnCheckedChangeListener(listenerRadio);
//
//        btnXem.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(DssvActivity.this, ViewDSSVActivity.class);
//            }
//        });
    }

    public void getEdit(){
             name = edtName.getText().toString();
             desc = edtDesc.getText().toString();
    }

    private void pickImageFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_PICK_CODE);
    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        switch (requestCode) {
//            case PERMISSION_CODE: {
//                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_DENIED) {
//                    pickImageFromGallery();
//                } else {
//                    Toast.makeText(this, "Permission denied...!", Toast.LENGTH_SHORT).show();
//                }
//            }
//        }
//
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK && requestCode == IMAGE_PICK_CODE){
        imgAva.setImageURI(data.getData());
         bm = ((BitmapDrawable)imgAva.getDrawable()).getBitmap();
        }
    }

    public void passData(){
//        String us = name + desc;
        Intent intent = new Intent(DssvActivity.this, ViewDSSVActivity.class);
//        intent.putExtra("us", us);
        BitmapHelper.getInstance().setBitmap(bm);
        startActivity(intent);
    }
}