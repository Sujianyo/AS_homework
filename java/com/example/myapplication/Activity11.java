package com.example.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity11 extends AppCompatActivity {
    Button button1;
    Button button2;
    TextView textView3;
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("cr","11:onDestroy...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("cr","11:onStop...");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("cr","11:onStart...");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("cr","11:onPostResume...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("cr","11:onPause...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("cr","11:onResume...");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("cr","11:onRestart...");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_11);
        button1 = findViewById(R.id.buttonA1);
        button2 = findViewById(R.id.buttonA2);
        textView3=findViewById(R.id.textView11);
        Log.d("cr", "11:onCreate...");

        /*MediaPlayer player=MediaPlayer.create(this,R.raw.music1);
        player.start();;
        player*/

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity11.this, Activity22.class);
                intent.putExtra("name", "cr");
                intent.putExtra("age",19);

                Bundle bundle=new Bundle();
                bundle.putString("name","cr");
                bundle.putInt("age",19);
                intent.putExtras(bundle);
                startActivity(intent);
            }

        });
        ActivityResultLauncher launcher=registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode()==666){
                            String str=result.getData().getStringExtra("result");
                            textView3.setText(str);
                        }
                    }
                });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3=new Intent(Activity11.this,Activity33.class);
                launcher.launch(intent3);
            }
        });
    }
}