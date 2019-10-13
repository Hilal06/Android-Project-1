package com.example.myproject.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.net.Uri;
import android.os.Bundle;

import com.example.myproject.R;
import com.example.myproject.fragment.ItemDetailFragment;
import com.example.myproject.fragment.ItemListFragment;
import com.example.myproject.fragment.LoginFragment;
import com.example.myproject.model.Item;


public class MainActivity extends AppCompatActivity implements
        ItemDetailFragment.OnFragmentInteractionListener,
        ItemListFragment.OnFragmentInteractionListener,
        LoginFragment.OnFragmentInteractionListener {

    private ItemDetailFragment itemDetailFragment;
    private ItemListFragment itemListFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemDetailFragment = new ItemDetailFragment();
        itemListFragment = new ItemListFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_frame, new LoginFragment())
                .commit();

    }

    @Override
    public void btnLoginClicked() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_frame, itemListFragment)
                .commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void buttonBack() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.main_frame);
        if (fragment != null) {

        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_frame, itemListFragment)
                .commit();
    }

    @Override
    public void onClickedItem(Item item) {
        Bundle bundle = new Bundle();
        bundle.putInt("ID_ITEM", item.getId());
        bundle.putInt("STOCK", item.getStok());
        bundle.putString("NAME", item.getName());
        bundle.putString("CODE", item.getCode());
        ItemDetailFragment itemDetailFragment = new ItemDetailFragment();
        itemDetailFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_frame,itemDetailFragment)
                .commit();
    }

    @Override
    public void onSave(int id, String name, String code, int stock) {

    }
}
