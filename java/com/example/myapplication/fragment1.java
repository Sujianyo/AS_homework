package com.example.myapplication;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class fragment1 extends Fragment{
    private View view;
    private Myadapter myadapter;
    private RecyclerView recyclerView;
    private List<String> list1;
    List <Map<String,Object>> data;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab1, container, false);
        recyclerView = view.findViewById(R.id.recycleview);

        data=new ArrayList<Map<String,Object>>();
        String[] names={"爸爸","妈妈","哥哥","姐姐","弟弟","妹妹"};
        String[] message={"这是爸爸的消息","这是妈妈的消息","这是哥哥的消息",
                "这是姐姐的消息","这是弟弟的消息","这是妹妹的消息"};
        String[] M_detail={"爸爸的消息内容","妈妈的消息内容","哥哥的消息内容",
                "姐姐的消息内容","弟弟的消息内容","妹妹的消息内容"};
        int[] image={R.drawable.picturef,R.drawable.picturem,R.drawable.pictureb,
                R.drawable.pictures,R.drawable.pictureyb,R.drawable.pictureys};
        /*list1 = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            list1.add("这是第" + i + "条消息");
        }*/
        for(int i=0;i<names.length;i++){
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("联系人",names[i]);
            map.put("消息",message[i]);
            map.put("头像",image[i]);
            map.put("消息内容",M_detail[i]);
            data.add(map);
        }
        myadapter = new Myadapter(view.getContext(), data);
        LinearLayoutManager manager = new LinearLayoutManager(view.getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(myadapter);
        return view;
    }
}
