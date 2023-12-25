package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;

public class Myadapter extends RecyclerView.Adapter <Myadapter.Myholder> {
    Context context1;
    //List<String> list1;
    List<Map<String,Object>> data1;
    public Myadapter(Context context,List<Map<String,Object>> data) {
        context1=context;
        data1=data;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context1).inflate(R.layout.item,parent,false);

        Myholder myholder=new Myholder(view);
        return myholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder,
                                 @SuppressLint("RecyclerView") int position) {
        holder.avatar.setImageResource((int)(data1.get(position).get("头像")));
        holder.name.setText(data1.get(position).get("联系人").toString());
        holder.content.setText(data1.get(position).get("消息").toString());
        holder.tipView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context1,MessageDetailActivity.class);
                /*intent.putExtra("头像",(int)data1.get(position).get("头像"));
                intent.putExtra("联系人",data1.get(position).get("消息").toString());*/
                intent.putExtra("消息内容",data1.get(position).get("消息内容").toString());

                context1.startActivity(intent);
                // context1.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data1.size();
    }
    public class Myholder extends RecyclerView.ViewHolder{
        LinearLayout tipView;
        TextView name;
        TextView content;
        ImageView avatar;
        public Myholder(@NonNull View itemView){

            super(itemView);
            tipView=itemView.findViewById(R.id.M_layout);
            name=itemView.findViewById(R.id.textViewM1);
            content=itemView.findViewById(R.id.textViewM2);
            avatar=itemView.findViewById(R.id.imageViewM);
        }
    }
}
