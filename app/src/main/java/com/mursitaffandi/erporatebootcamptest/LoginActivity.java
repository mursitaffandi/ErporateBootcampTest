package com.mursitaffandi.erporatebootcamptest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText mInputUsername, mInputPassword;
    Button mBtnSignIn;
    String mUsername, mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mInputUsername = (EditText) findViewById(R.id.edt_username);
        mInputPassword = (EditText) findViewById(R.id.edt_password);

        mBtnSignIn = (Button)findViewById(R.id.btn_signin);
        mBtnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUsername = mInputUsername.getText().toString();
                mPassword = mInputPassword.getText().toString();

                if (mUsername.equals("admin") && mPassword.equals("admin")){
                    Intent i = new Intent(LoginActivity.this, SplashActivity.class);
                    startActivity(i);
                    finish();
                } else {
                    mInputUsername.setText("");
                    mInputPassword.setText("");
                    Toast.makeText(LoginActivity.this, "Username and password unregistered", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
