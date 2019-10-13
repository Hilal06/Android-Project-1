package com.example.myproject.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myproject.R;
import com.example.myproject.model.CustomAdapter;
import com.example.myproject.model.Item;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ItemListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class ItemListFragment extends Fragment{

    private OnFragmentInteractionListener mListener;
    public ItemListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
        ListView listItem = view.findViewById(R.id.list);

        final int[] idItem = {1,2,3,4,5,6,7,8,9};
        final String[] name = {"Nike", "Laptop", "Pencil", "Sari Kurma", "Tessa", "Kopikap", "Nivea Deep Clean", "Vaseline Repairing gell", "Gatsby Pomade"};
        final String[] code = {"16266", "616244", "72654", "1244", "53134", "82663", "2532", "0946", "5513"};
        final String[] stock = {"13", "4", "50", "20", "50", "25", "20", "45", "12"};

        CustomAdapter customAdapter = new CustomAdapter(this.getContext(), idItem, name, code, stock);
        listItem.setAdapter(customAdapter);
        listItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item item = new Item(idItem[position], name[position], code[position], Integer.parseInt(stock[position]));
                mListener.onClickedItem(item);
            }
        });
        return view;
    }

    public void onEditItem(Item item) {

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
        void onClickedItem(Item item);
    }
}
