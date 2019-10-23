package com.example.myproject.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myproject.R;
import com.example.myproject.fragment.AddItemFragment;
import com.example.myproject.fragment.ItemDetailFragment;
import com.example.myproject.fragment.ItemListFragment;
import com.example.myproject.fragment.LoginFragment;
import com.example.myproject.fragment.RegisterFragment;
import com.example.myproject.model.Item;


public class MainActivity extends AppCompatActivity implements
        ItemDetailFragment.OnFragmentInteractionListener,
        ItemListFragment.OnFragmentInteractionListener,
        LoginFragment.OnFragmentInteractionListener,
        AddItemFragment.OnFragmentInteractionListener,
        RegisterFragment.OnFragmentInteractionListener {

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
    public void btnRegisterClicked() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_frame, new RegisterFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void addNewItem(Item item) {
        itemListFragment.newItem(item);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_frame, itemListFragment)
                .commit();
    }

    @Override
    public void buttonBack() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.main_frame);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_frame, itemListFragment)
                .commit();
    }

    @Override
    public void onClickedItem(Item item) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("DATA", item);
        ItemDetailFragment itemDetailFragment = new ItemDetailFragment();
        itemDetailFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_frame,itemDetailFragment)
                .commit();
    }

    @Override
    public void btnAdd() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_frame, new AddItemFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onSave(int id, String name, String code, int stock) {

    }
}
