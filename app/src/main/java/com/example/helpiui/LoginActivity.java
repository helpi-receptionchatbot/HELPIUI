package com.example.helpiui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText email, password;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.txtEmailId);
        password = findViewById(R.id.txtPassword);
        loginBtn = findViewById(R.id.btnLogin);
        read();
    }

    public void read() {
        loginBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (email.getText().toString().equals(""))
                            Toast.makeText(LoginActivity.this, getString(R.string.email_alert), Toast.LENGTH_SHORT).show();
                        else if (password.getText().toString().equals(""))
                            Toast.makeText(LoginActivity.this, getString(R.string.password_alert), Toast.LENGTH_SHORT).show();
                        else {
                            if (password.getText().toString().equals("1234")) {
                                if (getIntent().getStringExtra("type").equals("admin")) {
                                    Intent i = new Intent(LoginActivity.this, AdminActivity.class);
                                    startActivity(i);
                                }
                                if (getIntent().getStringExtra("type").equals("user")) {
                                    Intent i = new Intent(LoginActivity.this, UserActivity.class);
                                    startActivity(i);
                                }
                            } else
                                Toast.makeText(LoginActivity.this, getString(R.string.login_fail), Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
}
