package com.example.myproject.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myproject.R;
import com.example.myproject.model.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ItemDetailFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class ItemDetailFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private int id;
    private String nama;
    private String barcode;
    private int stock = 0;

    private TextView stockView;
    private EditText inputName, inputBarcode;

    public ItemDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item_detail, container, false);
        Bundle bundle = getArguments();
        final Item item = bundle.getParcelable("DATA");
        final int position = bundle.getInt("Position");
        if (bundle != null) {
            this.id = item.getId();
            this.nama = item.getName();
            this.barcode = item.getCode();
            this.stock = item.getStok();
        }
        stockView = view.findViewById(R.id.countStock);
        inputBarcode = view.findViewById(R.id.inputBarcode);
        inputName = view.findViewById(R.id.inputName);

        stockView.setText(String.valueOf(this.stock));
        inputName.setText(this.nama);
        inputBarcode.setText(this.barcode);

        Button btnPlus, btnMin;
        btnPlus = view.findViewById(R.id.btnPlus);
        btnMin = view.findViewById(R.id.btnMin);
        ImageButton btnUpdate = view.findViewById(R.id.btnUpdateItem);

        ImageView btnBack = view.findViewById(R.id.btnBack);
        // Listener on click
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int countStock = Integer.parseInt(stockView.getText().toString());
                stockView.setText(String.valueOf(countStock+1));
            }
        });
        btnMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int countStock = Integer.parseInt(stockView.getText().toString());
                if (countStock > 0) {
                    stockView.setText(String.valueOf(countStock-1));
                }
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.buttonBack();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = item.getId();
                String nama = inputName.getText().toString();
                String barcode = inputBarcode.getText().toString();
                int stock = Integer.parseInt(stockView.getText().toString());
                mListener.btnUpdateItem(id, nama, barcode, stock, position);
            }
        });
        return view;
    }

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
        void buttonBack();
        void btnUpdateItem(int id, String name, String code, int stock, int postion);
    }
}
