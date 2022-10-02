package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.*;
import android.os.Bundle;
import android.view.View;
import android.widget.*;




public class LoginActivity extends AppCompatActivity {
    String ACTIVITY_NAME = "LoginActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(ACTIVITY_NAME, "In onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final Button loginButton = findViewById(R.id.loginButton);
        final EditText loginName = findViewById(R.id.editTextEmail);
        final EditText passwordField = findViewById(R.id.passwordField);
        SharedPreferences sp = getSharedPreferences("DefaultEmail", MODE_PRIVATE);

        String default_email = sp.getString("DefaultEmail", "email@domain.com");
        loginName.setText(default_email);
        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("DefaultEmail", loginName.getText().toString());
                editor.commit();

                if (!loginName.getText().toString().isEmpty() && !Patterns.EMAIL_ADDRESS.matcher(loginName.getText().toString()).matches()) {
                    loginName.setError(getString(R.string.ValidEmail));
                }
                else if(passwordField.getText().toString().isEmpty()){
                    passwordField.setError(getString(R.string.ValidPass));
                }

                else{
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });






    }

    public void print(String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
    public void onStart()
    {
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");
    }
    public void onRestart()
    {
        super.onRestart();
        Log.i(ACTIVITY_NAME, "In onRestart()");
    }
    public void onResume()
    {
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");
    }
    public void onPause()
    {
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");
    }
    public void onStop()
    {
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop() ");
    }
    public void onDestroy()
    {
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy()");
    }
}
