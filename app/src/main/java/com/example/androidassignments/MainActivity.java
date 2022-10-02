package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String ACTIVITY_NAME = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(ACTIVITY_NAME, "In onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button Button = findViewById(R.id.button);
        Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, ListItemsActivity.class);
                startActivityForResult(intent, 10);
            }



        });

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10) {
            Log.i(ACTIVITY_NAME, "Returned to MainActivity.onActivityResult");
        }
        if (resultCode == Activity.RESULT_OK) {
            Log.i(ACTIVITY_NAME, "Photo Taken");
            String messagePassed = data.getStringExtra("Response");
            print("ListItemsActivity passed: " + messagePassed);
        }
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
