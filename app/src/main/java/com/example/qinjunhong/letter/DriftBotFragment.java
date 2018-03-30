package com.example.qinjunhong.letter;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DriftBotFragment extends Fragment implements AdapterView.OnItemClickListener{
    private List<Map<String, Object>> listDate;
    private ListView listView;
    private SimpleAdapter simpleAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_drift_bot, container, false);

        listView=(ListView)view.findViewById(R.id.dbotlist);
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

        return view;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragdrbot,new ReadFragment()).commit();
    }
}
