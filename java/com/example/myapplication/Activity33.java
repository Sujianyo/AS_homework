package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Activity33 extends AppCompatActivity {
    Button button3;
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("cr","33:onDestroy...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("cr","33:onStop...");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("cr","33:onStart...");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("cr","33:onPostResume...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("cr","33:onPause...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("cr","33:onResume...");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("cr","33:onRestart...");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_33);
        Log.d("cr","33:onCreate...");
        button3=findViewById(R.id.buttonB1);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.putExtra("result","888");
                setResult(666,intent);
                finish();
            }
        });
    }
}