package com.example.myproject.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myproject.R;
import com.example.myproject.model.User;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LoginFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class LoginFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private ItemListFragment listFragment;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        final EditText username = view.findViewById(R.id.txtEmail);
        final EditText password = view.findViewById(R.id.txtPassword);
        final ArrayList<User> listUser = new ArrayList<User>();
        listUser.add(new User("Rifaul", "Rifaul"));
        listUser.add(new User("paul","paul"));

        Button btnSignIn = view.findViewById(R.id.btnLogin);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    String usr = username.getText().toString();
                    String pass = password.getText().toString();

                    if (!TextUtils.isEmpty(usr) && !TextUtils.isEmpty(pass)) {
                        boolean cek = false;
                        for (int i=0; i<listUser.size(); i++) {
                            if (listUser.get(i).getUsername().equals(usr) && listUser.get(i).getPassword().equals(pass)) {
                                mListener.btnLoginClicked();
                                cek = false;
                            } else {
                                cek = true;
                            }
                        }
                        if (cek) {
                            Toast.makeText(getActivity(), "Please check your account!!", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(getActivity(), "Please Enter Your Username and Password", Toast.LENGTH_SHORT).show();
                    }
                }
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
        void btnLoginClicked();
    }
}
