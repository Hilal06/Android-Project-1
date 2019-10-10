package com.example.myproject.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myproject.R;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    Context context;
    ArrayList<Item> listItem;
    LayoutInflater inflater;

    public CustomAdapter(Context context, ArrayList<Item> listItem) {
        this.context = context;
        this.listItem = listItem;
        this.inflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item, null);
        TextView name = (TextView) convertView.findViewById(R.id.textNama);
        TextView stock = (TextView) convertView.findViewById(R.id.textStock);
        TextView code = (TextView) convertView.findViewById(R.id.textCode);

        name.setText(listItem.get(position).getName());
        stock.setText(String.valueOf(listItem.get(position).getStok()));
        code.setText(listItem.get(position).getCode());
        return convertView;
    }
}
