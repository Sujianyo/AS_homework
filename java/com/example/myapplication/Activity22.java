package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity22 extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("cr","22:onDestroy...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("cr","22:onStop...");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("cr","22:onStart...");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("cr","22:onPostResume...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("cr","22:onPause...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("cr","22:onResume...");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("cr","22:onRestart...");
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_22);
        textView=findViewById(R.id.textView22);
        Intent intent=getIntent();
        String str2=intent.getExtras().getString("name")+":"+intent.getExtras().getInt("age");
        //String str=intent.getStringExtra("name")+"-"+intent.getIntExtra("age",1);
        textView.setText(str2);
        Log.d("cr","22:onCreate...");
    }
}