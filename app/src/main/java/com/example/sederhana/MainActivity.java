package com.example.sederhana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    String Username,Password;
    TextInputEditText username,password;
    TextInputLayout layoutusername,layoutpassword;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layoutpassword = findViewById(R.id.layoutpassword);
        layoutusername = findViewById(R.id.layoutuser);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.btnLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Username = username.getText().toString();
                Password = password.getText().toString();
                if (Username.length()==0){
                    layoutusername.setError("field tidak boleh kosong");
                }else if (Username != "admin"){
                    layoutusername.setError("Masukkan username yang valid");
                    if (Username.equals("admin") || Username.equals("user")){
                        layoutusername.setError(null);
                        layoutusername.setErrorEnabled(false);
                    }
                }
                if (Password.length()==0){
                    layoutpassword.setError("Password tidak boleh kosong");
                }else if (Password != "admin"){
                    layoutpassword.setError("Masukkan password yang valid");
                    if(Password.equals("admin") || Password.equals("user")){
                        layoutpassword.setError(null);
                        layoutpassword.setErrorEnabled(false);
                    }
                }

                if (Username.equals("admin") && Password.equals("user")){
                    layoutpassword.setError("Masukkan password yang valid");
                }else if (Username.equals("user") && Password.equals("admin")){
                    layoutpassword.setError("Masukkan password yang valid");
                }

                if (Username.equals("admin") && Password.equals("admin")){
                    Intent admin = new Intent(MainActivity.this,LamanAdmin.class);
                    startActivity(admin);
                }
                if (Username.equals("user") && Password.equals("user")){
                    Intent user = new Intent(MainActivity.this,LamanUser.class);
                    startActivity(user);
                }
            }
        });

        }
    }

