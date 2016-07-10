package com.liwenyu.aeropedia;

import android.support.annotation.NonNull;
import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;


/*
 * Created by Jay on 2015/8/28 0028.
 */
public class MyFragment1 extends ListFragment {

    private AnimalListAdapter adapter = null;


    public List<Aerocraft> airplanes1;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        airplanes1=new ArrayList<Aerocraft>();

        airplanes1.addAll(MainActivity.getairplane());


        adapter = new AnimalListAdapter (getActivity(),airplanes1);


        setListAdapter(adapter);





    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        System.out.println("Click On List Item!!!");
        super.onListItemClick(l, v, position, id);
    }
    public MyFragment1() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment1, container, false);
       // listView = (ListView) view.findViewById(R.id.listView);
        //init();
       /* TextView txt_content = (TextView) view.findViewById(R.id.txt_content);
        txt_content.setText("第一个Fragment");*/



        Log.e("HEHE", "1日狗");
        return view;
    }






    }



