package com.liwenyu.aeropedia;

/*
 * Created by LiWenyu on 2015/9/16.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


class ViewHolder {
    public TextView animal;
    public TextView cn_word;
    public TextView en_word;

}
public class AnimalListAdapter extends BaseAdapter{

    private List<Aerocraft> airplanes;
    Context context;


    private LayoutInflater mInflater = null;

    public AnimalListAdapter(Context context,List<Aerocraft> airplanes){
        super();
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.airplanes = airplanes;


    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return (airplanes==null)?0:airplanes.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub

        return airplanes.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Aerocraft airplanes = (Aerocraft)getItem(position);

        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.view_type, null);
            holder.animal = (TextView) convertView.findViewById(R.id.textjixing);
            holder.cn_word = (TextView) convertView.findViewById(R.id.textsuoxie);
            holder.en_word = (TextView) convertView.findViewById(R.id.textleibie);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.animal.setText(airplanes.mingcheng);
        holder.cn_word.setText(airplanes.suoxie);
        holder.en_word.setText(airplanes.leibie);




        return convertView;
    }

}
