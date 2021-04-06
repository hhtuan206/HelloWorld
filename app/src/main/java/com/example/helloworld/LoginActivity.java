package com.example.helloworld;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText editUsername;
    private EditText editPassword;
    private CheckBox cbRemember;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getViews();
        SharedPreferences pre = getSharedPreferences("UsInfo", MODE_PRIVATE);
        final SharedPreferences.Editor editor = pre.edit();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editUsername.getText().toString().equals("admin") && editPassword.getText().toString().equals("123")){
                    if(cbRemember.isChecked()){
                        editor.putString("Username",editUsername.getText().toString());
                        editor.putString("Password",editPassword.getText().toString());
                        editor.putBoolean("Remember",true);
                        editor.commit();
                    }else{
                        editor.clear();
                    }

                    Intent intent = new Intent(LoginActivity.this, LoginSuccessActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this, "Sai pass or user", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    protected  void onResume(){
        super.onResume();
        restorePre();
    }

    void restorePre(){
        SharedPreferences pre = getSharedPreferences("UsInfo",MODE_PRIVATE);
        boolean remember = pre.getBoolean("Remember", false);
        if(remember){
            editUsername.setText(pre.getString("Username",""));
            editPassword.setText(pre.getString("Password",""));
        }
        cbRemember.setChecked(remember);
    }

    void getViews(){
        btnLogin = findViewById(R.id.btnLogin);
        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        cbRemember = findViewById(R.id.cbRemember);
    }
}