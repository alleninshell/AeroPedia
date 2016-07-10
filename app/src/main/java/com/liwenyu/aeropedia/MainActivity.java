package com.liwenyu.aeropedia;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.liwenyu.aeropedia.MyFragmentPagerAdapter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Coder-pig on 2015/8/28 0028.
 */
public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,
        ViewPager.OnPageChangeListener {

    //UI Objects
    private TextView txt_topbar;
    private RadioGroup rg_tab_bar;
    private RadioButton rb_channel;
    private RadioButton rb_message;
    private RadioButton rb_better;
    private RadioButton rb_setting;
    private ViewPager vpager;

    private MyFragmentPagerAdapter mAdapter;

    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;


    public static List<Aerocraft> airplanes;


    public void initListAllairplanes() {





        Aerocraft anewairplane = null;


        airplanes = new ArrayList<Aerocraft>();

        String str=null;



        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.airplanesdb)));

            int line = 1;



            while((str=br.readLine())!=null){
                anewairplane = new Aerocraft(0,"","","");

                int n = 0;
                int maxn=str.length();

                   while (str.charAt(n) != ',') {
                        anewairplane.mingcheng = anewairplane.mingcheng + str.charAt(n);
                        n = n + 1;
                    }
                    n = n + 1;
                    while (str.charAt(n) != ',') {
                        anewairplane.suoxie = anewairplane.suoxie + str.charAt(n);
                        n = n + 1;
                    }
                    n = n + 1;
                    while (n != maxn) {
                        anewairplane.leibie = anewairplane.leibie + str.charAt(n);
                        n = n + 1;
                    }
                airplanes.add(new Aerocraft(line, anewairplane.mingcheng, anewairplane.suoxie, anewairplane.leibie));
                line=line+1;


            }


        } catch (IOException e) {
            e.printStackTrace();
        }










        /*
        airplanes.add(new Aerocraft(100, "李小龙", "香港", "A"));
        airplanes.add(new Aerocraft(101, "施瓦辛格", "美国", "B"));
        airplanes.add(new Aerocraft(102, "戴安娜王妃", "英国", "C"));
        airplanes.add(new Aerocraft(103, "成龙", "香港", "A"));
        airplanes.add(new Aerocraft(104, "史泰龙", "美国", "A"));
        airplanes.add(new Aerocraft(105, "圣女贞德", "法国", "A"));
        airplanes.add(new Aerocraft(106, "列宁", "苏联", "A"));
        airplanes.add(new Aerocraft(107, "爱迪生", "美国", "A"));
        airplanes.add(new Aerocraft(108, "孔子", "中国", "A"));
        airplanes.add(new Aerocraft(109, "杨七郎", "宋朝", "A"));
        airplanes.add(new Aerocraft(110, "秦始皇", "秦国", "A"));
        airplanes.add(new Aerocraft(111, "岳飞", "宋朝", "A"));
        airplanes.add(new Aerocraft(2001, "B737-800", "B738", "C"));
        */

    }



       public static ArrayList<Aerocraft> getairplane(){
         ArrayList<Aerocraft> newair= new ArrayList<Aerocraft>();
         newair.addAll(airplanes);
           return newair;
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        bindViews();
        rb_channel.setChecked(true);
        initListAllairplanes();




    }

    private void bindViews() {
        txt_topbar = (TextView) findViewById(R.id.txt_topbar);
        rg_tab_bar = (RadioGroup) findViewById(R.id.rg_tab_bar);
        rb_channel = (RadioButton) findViewById(R.id.rb_channel);
        rb_message = (RadioButton) findViewById(R.id.rb_message);
        rb_better = (RadioButton) findViewById(R.id.rb_better);
        rb_setting = (RadioButton) findViewById(R.id.rb_setting);
        rg_tab_bar.setOnCheckedChangeListener(this);

        vpager = (ViewPager) findViewById(R.id.vpager);
        vpager.setAdapter(mAdapter);
        vpager.setCurrentItem(0);
        vpager.addOnPageChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_channel:
                vpager.setCurrentItem(PAGE_ONE);
                break;
            case R.id.rb_message:
                vpager.setCurrentItem(PAGE_TWO);
                break;
            case R.id.rb_better:
                vpager.setCurrentItem(PAGE_THREE);
                break;
            case R.id.rb_setting:
                vpager.setCurrentItem(PAGE_FOUR);
                break;
        }
    }


    //重写ViewPager页面切换的处理方法
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
        if (state == 2) {
            switch (vpager.getCurrentItem()) {
                case PAGE_ONE:
                    rb_channel.setChecked(true);
                    break;
                case PAGE_TWO:
                    rb_message.setChecked(true);
                    break;
                case PAGE_THREE:
                    rb_better.setChecked(true);
                    break;
                case PAGE_FOUR:
                    rb_setting.setChecked(true);
                    break;
            }
        }
    }
}
