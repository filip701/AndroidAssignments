package com.example.androidassignments;

import static android.app.ProgressDialog.show;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.util.Log;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

public class ListItemsActivity extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "ListItemsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(ACTIVITY_NAME, "In onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);

        ImageButton camera = findViewById(R.id.camera);
        final Switch switch1 = findViewById(R.id.switch1);
        final CheckBox Check = findViewById(R.id.checkBox);


        camera.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent newpic = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(newpic, 10);
            }

        });

        switch1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(switch1.isChecked()){
                    Toast.makeText(ListItemsActivity.this, getString(R.string.ButtonOn), Toast.LENGTH_SHORT).show();
                }
                else{
                    print(getString(R.string.ButtonOff));
                }
            }
        });


        Check.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                AlertDialog.Builder builder = new AlertDialog.Builder(ListItemsActivity.this);
                builder.setMessage(getString(R.string.finish));
                builder.setPositiveButton(getString(R.string.Yes), (dialog, id) -> {
                    Intent resultIntent = new Intent(  );
                    resultIntent.putExtra("Response", getString(R.string.Share));
                    setResult(Activity.RESULT_OK, resultIntent);
                    finish();
                });
                builder.setNegativeButton(getString(R.string.No), (dialog, id) -> Check.setChecked(false));
                builder.show();
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 &&
                resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ImageButton btnImg = findViewById(R.id.camera);
            btnImg.setImageBitmap(imageBitmap);
            try {
                MediaStore.Images.Media.insertImage(getContentResolver(), imageBitmap, "Title", "Description");
            } catch (Exception e) {
            }
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