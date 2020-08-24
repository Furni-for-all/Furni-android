package com.example.furni;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SearchView;

import com.bumptech.glide.Glide;
import com.example.furni.helperClass.AdapterLegs;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import java.util.ArrayList;
import java.util.List;

public class Legs extends AppCompatActivity {

    List<String> titles;
    List<Integer> images;
    RecyclerView myList;
    SearchView mySearchView;
    AdapterLegs adapter;
    //TextView name;
    ImageView profile_photo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legs);

        //name = findViewById(R.id.username);
        profile_photo = findViewById(R.id.profile_photo);

        //mySearchView = findViewById(R.id.search_bar);
        myList = findViewById(R.id.myList);

        titles = new ArrayList<>();
        images = new ArrayList<>();

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            //String personName = acct.getDisplayName();
            Uri personPhoto = acct.getPhotoUrl();
            //name.setText(personName);
            Glide.with(this).load(String.valueOf(personPhoto)).into(profile_photo);
        }

        titles.add("Living Room");
        titles.add("Bedroom");
        titles.add("Bathroom");
        titles.add("Kitchen/ Dining");
        titles.add("Daily Living Aids");
        titles.add("Health Care");
        titles.add("Mobility Aids");
        titles.add("Leisure");

        images.add(R.drawable.livingroom);
        images.add(R.drawable.bedroom);
        images.add(R.drawable.bathroom);
        images.add(R.drawable.kitchen);
        images.add(R.drawable.dailyliving);
        images.add(R.drawable.healthcare);
        images.add(R.drawable.mobility);
        images.add(R.drawable.leisure);

        adapter = new AdapterLegs(this, titles,images);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        myList.setLayoutManager(gridLayoutManager);
        myList.setAdapter(adapter);





//        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String s) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String s) {
//
//                adapter.getFilter().filter(s);
//                return false;
//            }
//        });

    }
}