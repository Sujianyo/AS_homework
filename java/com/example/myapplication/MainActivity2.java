package com.example.myapplication;

import android.Manifest;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity2 extends AppCompatActivity {

    Button button;
    MyReceiver2 myReceiver2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button=findViewById(R.id.buttonR);

        String[] permissions={Manifest.permission.RECEIVE_SMS};
        int requestCode=999;

        ActivityCompat.requestPermissions(this,permissions,requestCode);

        String actionname="cr.broadcast.666";
        Intent intent=new Intent(actionname);


        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                sendBroadcast(intent);
            }
        },1000);

        myReceiver2=new MyReceiver2();
        IntentFilter filter=new IntentFilter();
        filter.addAction(actionname);
        registerReceiver(myReceiver2,filter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendBroadcast(intent);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 999) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // 用户授予了短信权限，可以执行读取短信的操作
                // 执行读取短信的逻辑...
            } else {
                // 用户拒绝了短信权限，你可以根据需要进行适当的处理
            }
        }
    }
}