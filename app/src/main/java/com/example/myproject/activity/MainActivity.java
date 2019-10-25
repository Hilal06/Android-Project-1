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
import com.example.myproject.model.User;


public class MainActivity extends AppCompatActivity implements
        ItemDetailFragment.OnFragmentInteractionListener,
        ItemListFragment.OnFragmentInteractionListener,
        LoginFragment.OnFragmentInteractionListener,
        AddItemFragment.OnFragmentInteractionListener,
        RegisterFragment.OnFragmentInteractionListener {

    private ItemDetailFragment itemDetailFragment;
    private ItemListFragment itemListFragment;
    private LoginFragment loginFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginFragment = new LoginFragment();
        loginFragment.onInitUser();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_frame, loginFragment)
                .commit();

    }

    @Override
    public void btnLoginClicked() {
        itemListFragment = new ItemListFragment();
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
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_frame, itemListFragment)
                .commit();
    }

    @Override
    public void btnUpdateItem(int id, String name, String code, int stock, int position) {
        Item item = new Item();
        item.setId(id);
        item.setName(name);
        item.setStok(stock);
        item.setCode(code);
        itemListFragment.onEditItem(position, item);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_frame, itemListFragment)
                .commit();
    }

    @Override
    public void onClickedItem(int position,Item item) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("DATA", item);
        bundle.putInt("Position", position);
        itemDetailFragment = new ItemDetailFragment();
        itemDetailFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_frame,itemDetailFragment)
                .addToBackStack(null)
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
    public void newUser(User user) {
        loginFragment.addUser(user);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_frame, loginFragment)
                .commit();
    }
}
