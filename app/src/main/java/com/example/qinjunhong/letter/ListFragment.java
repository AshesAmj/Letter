package com.example.qinjunhong.letter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class ListFragment extends Fragment
        implements AdapterView.OnItemClickListener{


            //声明ListView控件
            private ListView listView;
            //创建简单适配器(并不简单,功能很强大)

            //定义List泛型集合,里面存放的是Map键值对, listDate作为ListView的数据源
            private List<Map<String, Object>> listDate;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
       View view =inflater.inflate(R.layout.fragment_list, container, false);
        listView = (ListView)view.findViewById(R.id.listview);
        int[] img =new int[]{R.drawable.write1,R.drawable.lettericon,R.drawable.dirftbottle1};
        String[]textlist=new String[]{"Write","Receive","Drift Bottle"};
        listDate = new ArrayList<>();

        for(int i =0;i<img.length;i++)
        {
            Map<String, Object> map = new HashMap<>();
            map.put("img", img[i]);
            map.put("textlist", textlist[i]);;
            listDate.add(map);

        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(getContext(),
                listDate,
                R.layout.image_item,
                new String[]{"img", "textlist"},
                new int[]{R.id.imageList, R.id.textList});
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        /**
         * 我们要实现的功能是:你点击了ListView的每一项时,会弹出该Item的文本信息
         *  listView.getItemAtPosition(position)得到的是一个Object对象,须把它转化成String类型
         *  方法调用后我们还应在onCreate()函数里面启用监听器
         */
        if(position==0){
            Intent intent = new Intent(getActivity(), WriteActivity.class);
            startActivity(intent);
        }
         if(position==1)
        {
            Intent intent = new Intent(getActivity(), RecevieActivity.class);
            startActivity(intent);
        }
         if(position==2)
         {
             Intent intent = new Intent(getActivity(), DriftBotActivity.class);
             startActivity(intent);
         }
    }


}
