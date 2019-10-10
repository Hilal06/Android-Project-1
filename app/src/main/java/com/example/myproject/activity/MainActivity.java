package com.example.myproject.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.net.Uri;
import android.os.Bundle;

import com.example.myproject.R;
import com.example.myproject.fragment.ItemListFragment;
import com.example.myproject.fragment.LoginFragment;

public class MainActivity extends AppCompatActivity implements
        ItemListFragment.OnFragmentInteractionListener,
        LoginFragment.OnFragmentInteractionListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_frame, new LoginFragment())
                .commit();

    }

    @Override
    public void btnLoginClicked() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_frame, new ItemListFragment())
                .commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
