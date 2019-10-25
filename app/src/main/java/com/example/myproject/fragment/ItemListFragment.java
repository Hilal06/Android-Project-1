package com.example.myproject.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myproject.R;
import com.example.myproject.activity.MainActivity;
import com.example.myproject.model.CustomAdapter;
import com.example.myproject.model.Item;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ItemListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class ItemListFragment extends Fragment{

    private OnFragmentInteractionListener mListener;

    private ArrayList<String> ids = new ArrayList<>();
    private ArrayList<String> nm = new ArrayList<>();
    private ArrayList<String> cd = new ArrayList<>();
    private ArrayList<String> stk = new ArrayList<>();

    private String[] idItem;
    private String[] name;
    private String[] code;
    private String[] stock;

    private ListView listItem;
    private CustomAdapter customAdapter;


    public ItemListFragment() {
        // Required empty public constructor
        onInit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
        listItem = view.findViewById(R.id.list);
        customAdapter = new CustomAdapter(this.getContext(),idItem, name, code, stock);
        listItem.setAdapter(this.customAdapter);
        listItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    Item item = new Item(Integer.valueOf(idItem[position]), name[position], code[position], Integer.valueOf(stock[position]));
                    mListener.onClickedItem(position,item);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });

        FloatingActionButton floatingActionButton = view.findViewById(R.id.floatingAddButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.btnAdd();
            }
        });
        return view;
    }

    public void onInit(){
        this.ids.add("1");
        this.ids.add("2");
        this.nm.add("Asus A405U");
        this.nm.add("Lenovo Thinkpad");
        this.cd.add("1222");
        this.cd.add("11223");
        this.stk.add("11");
        this.stk.add("15");

        this.idItem = ids.toArray(new String[ids.size()]);
        this.name = nm.toArray(new String[nm.size()]);
        this.code = cd.toArray(new String[cd.size()]);
        this.stock = stk.toArray(new String[stk.size()]);
    }

    public void onEditItem(int position,Item item) {
        ArrayList<String> id = new ArrayList<>(Arrays.asList(this.idItem));
        ArrayList<String> names = new ArrayList<>(Arrays.asList(this.name));
        ArrayList<String> codes = new ArrayList<>(Arrays.asList(this.code));
        ArrayList<String> stocks = new ArrayList<>(Arrays.asList(this.stock));
        int idx = position;
        try {
            id.set(idx, String.valueOf(idx));
            names.set(idx, item.getName());
            codes.set(idx, item.getCode());
            stocks.set(idx, String.valueOf(item.getStok()));
            this.idItem = id.toArray(new String[id.size()]);
            this.name = names.toArray(new String[names.size()]);
            this.code = codes.toArray(new String[codes.size()]);
            this.stock = stocks.toArray(new String[stocks.size()]);

        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public void newItem(Item item) {
        ArrayList<String> id = new ArrayList<>(Arrays.asList(idItem));
        ArrayList<String> names = new ArrayList<>(Arrays.asList(name));
        ArrayList<String> codes = new ArrayList<>(Arrays.asList(code));
        ArrayList<String> stocks = new ArrayList<>(Arrays.asList(stock));
        id.add(String.valueOf(id.size() + 1));
        names.add(item.getName());
        codes.add(item.getCode());
        stocks.add(String.valueOf(item.getStok()));

        this.idItem = id.toArray(new String[id.size()]);
        this.name = names.toArray(new String[names.size()]);
        this.code = codes.toArray(new String[codes.size()]);
        this.stock = stocks.toArray(new String[stocks.size()]);

    }

    // cannot be use
    public void doDeleteItem(int index) {
        ArrayList<String> id = new ArrayList<>(Arrays.asList(idItem));
        ArrayList<String> names = new ArrayList<>(Arrays.asList(name));
        ArrayList<String> codes = new ArrayList<>(Arrays.asList(code));
        ArrayList<String> stocks = new ArrayList<>(Arrays.asList(stock));
        try {
            id.remove(index);
            names.remove(index);
            codes.remove(index);
            stocks.remove(index);

            this.idItem = id.toArray(new String[id.size()+1]);
            this.name = names.toArray(new String[names.size()+1]);
            this.code = codes.toArray(new String[codes.size()+1]);
            this.stock = stocks.toArray(new String[stocks.size()+1]);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    // TODO: Rename method, update argument and hook method into UI event

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
        void onClickedItem(int position,Item item);
        void btnAdd();
    }
}
