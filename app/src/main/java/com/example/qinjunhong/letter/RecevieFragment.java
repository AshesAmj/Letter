package com.example.qinjunhong.letter;


import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecevieFragment extends Fragment
        implements AdapterView.OnItemClickListener,AbsListView.OnScrollListener{



    private List<Map<String, Object>> listDate;
    private ListView listView;
    private SimpleAdapter simpleAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_list, container, false);

        listView=(ListView)view.findViewById(R.id.listview);
        // Inflate the layout for this fragment
        String textlist="From:xx";
        listDate = new ArrayList<>();
        for(int i =0;i<15;i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("textlist", textlist+i);
            listDate.add(map);
        }
         simpleAdapter = new SimpleAdapter(getContext(),
                listDate,
                R.layout.item_receive,
                new String[]{"textlist"},
                new int[]{ R.id.textrece});
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(this);
        listView.setOnScrollListener(this);

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String text = "" + listView.getItemAtPosition(position);

        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragrece,new ReadFragment()).commit();



    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        switch(scrollState)
        {
            case SCROLL_STATE_FLING:

                Log.i("Main", "用户在手指离开屏幕之前，由于用力的划了一下，视图仍依靠惯性继续滑动");

                //模拟刷新功能
                Map<String, Object>map = new HashMap<>();
                map.put("textlist","From:");
                listDate.add(map);

                //通知视图界面更新
                simpleAdapter.notifyDataSetChanged();
                //listView.setAdapter(simpleAdapter);
                break;

            case SCROLL_STATE_IDLE:

                Log.i("Main","视图已经停止滑动");
                break;

            case SCROLL_STATE_TOUCH_SCROLL:

                Log.i("Main","手指没有离开屏幕，视图跟随手指滑动");
                break;
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }



}
