package com.example.myproject.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myproject.R;
import com.example.myproject.fragment.ItemListFragment;

import java.util.zip.Inflater;

public class CustomAdapter extends ArrayAdapter<String> {
    int id[];
    String[] name;
    String[] barcode;
    String[] stock;

    public CustomAdapter(Context context, int[] id, String[] name, String[] barcode, String[] stock) {
        super(context, R.layout.item, name);
        this.id = id;
        this.name = name;
        this.barcode = barcode;
        this.stock = stock;
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
