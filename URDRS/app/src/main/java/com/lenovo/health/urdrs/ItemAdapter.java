package com.lenovo.health.urdrs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by tianye4 on 2015/5/4.
 */
public class ItemAdapter extends BaseAdapter {
    private ArrayList<ItemData> itemDatas;
    private Context context;
    public ItemAdapter(Context context, ArrayList<ItemData> itemDatas) {
        this.itemDatas = itemDatas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return itemDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return itemDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView =  inflater.inflate(R.layout.item_layout, null);
            viewHolder = new ViewHolder();
            viewHolder.titleview = (TextView) convertView.findViewById(R.id.item_name);
            viewHolder.introView = (TextView) convertView.findViewById(R.id.item_discription);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.item_image);
            convertView.setTag(viewHolder);

        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.titleview.setText(itemDatas.get(position).getTitle());
        viewHolder.introView.setText(itemDatas.get(position).getIntro());
        return convertView;
    }

    class ViewHolder {
        TextView titleview;
        TextView introView;
        ImageView imageView;
    }
}
