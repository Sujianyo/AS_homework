package com.example.kook;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;




public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Fragment kookFragment=new kookFragment();
    private Fragment bookFragment=new bookFragment();
    private Fragment findFragment=new findFragment();
    private Fragment myFragment=new myFragment();

    private android.app.FragmentManager fragmentManager;

    private LinearLayout LinearLayout1,LinearLayout2,LinearLayout3,LinearLayout4;

    private ImageView ImageView1,ImageView2,ImageView3,ImageView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        LinearLayout1=findViewById(R.id.LinearLayout_kook);
        LinearLayout2=findViewById(R.id.LinearLayout_book);
        LinearLayout3=findViewById(R.id.LinearLayout_find);
        LinearLayout4=findViewById(R.id.LinearLayout_my);

        ImageView1=findViewById(R.id.imageView7);
        ImageView2=findViewById(R.id.imageView4);
        ImageView3=findViewById(R.id.imageView5);
        ImageView4=findViewById(R.id.imageView6);

        LinearLayout1.setOnClickListener(this);
        LinearLayout2.setOnClickListener(this);
        LinearLayout3.setOnClickListener(this);
        LinearLayout4.setOnClickListener(this);
        initFragment();
        showFragment(0);
    }

    private void initFragment(){
        fragmentManager=getFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.add(R.id.content,kookFragment);
        transaction.add(R.id.content,bookFragment);
        transaction.add(R.id.content,findFragment);
        transaction.add(R.id.content,myFragment);
        transaction.commit();

    }

    private void hideFragment(FragmentTransaction transaction){
        transaction.hide(kookFragment);
        transaction.hide(bookFragment);
        transaction.hide(findFragment);
        transaction.hide(myFragment);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.LinearLayout_kook:
                showFragment(0);
                break;
            case R.id.LinearLayout_book:
                showFragment(1);
                break;
            case R.id.LinearLayout_find:
                showFragment(3);
                break;
            case R.id.LinearLayout_my:
                showFragment(4);
                break;
            default:
                break;
        }
    }

    private void showFragment(int i) {
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        hideFragment(transaction);
        switch(i){
            case 0:
                transaction.show(kookFragment);
                ImageView1.setImageResource(R.drawable.img_1);
                ImageView2.setImageResource(R.drawable.img_2);
                ImageView3.setImageResource(R.drawable.img_3);
                ImageView4.setImageResource(R.drawable.img_3);
                break;
            case 1:
                transaction.show(bookFragment);
                ImageView2.setImageResource(R.drawable.img_1);
                ImageView1.setImageResource(R.drawable.img_2);
                ImageView3.setImageResource(R.drawable.img_3);
                ImageView4.setImageResource(R.drawable.img_4);
                break;
            case 3:
                transaction.show(findFragment);
                ImageView3.setImageResource(R.drawable.img_1);
                ImageView1.setImageResource(R.drawable.img_2);
                ImageView2.setImageResource(R.drawable.img_3);
                ImageView4.setImageResource(R.drawable.img_4);
                break;
            case 4:
                transaction.show(myFragment);
                ImageView4.setImageResource(R.drawable.img_1);
                ImageView1.setImageResource(R.drawable.img_2);
                ImageView2.setImageResource(R.drawable.img_3);
                ImageView3.setImageResource(R.drawable.img_4);
                break;
            default:
                break;
        }
        transaction.commit();
    }
}