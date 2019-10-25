package com.example.myproject.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myproject.R;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<String> {
    String[] id;
    String[] name;
    String[] barcode;
    String[] stock;

    public CustomAdapter(Context context, String[] id, String[] name, String[] barcode, String[] stok) {
        super(context, R.layout.item, id);
        this.id = id;
        this.name = name;
        this.barcode = barcode;
        this.stock = stok;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.item, parent, false);
        TextView name = convertView.findViewById(R.id.textNama);
        TextView barcode = convertView.findViewById(R.id.textCode);
        TextView stock = convertView.findViewById(R.id.textStock);
        name.setText(this.name[position]);
        barcode.setText(this.barcode[position]);
        stock.setText(this.stock[position]);


        return convertView;
    }
}
