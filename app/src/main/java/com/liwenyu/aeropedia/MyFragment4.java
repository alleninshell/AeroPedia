package com.liwenyu.aeropedia;

import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Jay on 2015/8/28 0028.
 */
public class MyFragment4 extends ListFragment {

    public MyFragment4() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment4,container,false);
        /*TextView txt_content = (TextView) view.findViewById(R.id.txt_content);
        txt_content.setText("第四个Fragment");*/
        Log.e("HEHE", "4日狗");
        return view;
    }
}
