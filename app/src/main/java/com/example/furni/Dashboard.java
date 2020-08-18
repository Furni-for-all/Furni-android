package com.example.furni;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Filterable;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;
import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity {

    TextView name, email;
    ImageView signout, profile_photo;
    FirebaseAuth mAuth;
    GoogleSignInClient mGoogleSignInClient;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;
    SearchView mySearchView;
    RecyclerView myList;
    List<String> titles;
    List<Integer> images;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

//        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                FirebaseUser user = firebaseAuth.getCurrentUser();
//                if (user != null) {
//                        setUserData(user);
//                }
//                else{
//                    Intent intent = new Intent(Dashboard.this, MainActivity.class);
//                    startActivity(intent);
//                }
//            }
//        };

        name = findViewById(R.id.username);
        profile_photo = findViewById(R.id.profile_photo);
        mySearchView = findViewById(R.id.search_bar);

        myList = findViewById(R.id.myList);

        titles = new ArrayList<>();
        images = new ArrayList<>();

        titles.add("Dwarf");
        titles.add("Ears");
        titles.add("Eyes");
        titles.add("Hands");
        titles.add("Legs");
        titles.add("Mental Disability");
        titles.add("Speech Disability");
        titles.add("Spinal");

        images.add(R.drawable.dwarf);
        images.add(R.drawable.ears);
        images.add(R.drawable.eyes);
        images.add(R.drawable.hands);
        images.add(R.drawable.legs);
        images.add(R.drawable.brain);
        images.add(R.drawable.speech);
        images.add(R.drawable.spinal);


        adapter = new Adapter(this, titles,images);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1,GridLayoutManager.VERTICAL,false);
        myList.setLayoutManager(gridLayoutManager);
        myList.setAdapter(adapter);


        myList.setAdapter(adapter);


        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                adapter.getFilter().filter(s);
                return false;
            }
        });

        signout = findViewById(R.id.signout_button);
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                switch (view.getId()) {

                    case R.id.signout_button:
                        signOut();
                        break;

                }
            }
        });
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            String personName = acct.getDisplayName();

            String personEmail = acct.getEmail();

            Uri personPhoto = acct.getPhotoUrl();

            name.setText(personName);
           // email.setText(personEmail);
            Glide.with(this).load(String.valueOf(personPhoto)).into(profile_photo);
        }
    }


//    private void setUserData(FirebaseUser user) {
//        String personName = user.getDisplayName();
//
//            String personEmail = user.getEmail();
//
//            Uri personPhoto = user.getPhotoUrl();
//
//            name.setText(personName);
//            email.setText(personEmail);
//            Glide.with(this).load(String.valueOf(personPhoto)).into(imageView);
//
//    }


//    @Override
//    public void onStart() {
//        super.onStart();
//        mAuth.addAuthStateListener(firebaseAuthListener);
//
//    }

    private void signOut() {
        FirebaseAuth.getInstance().signOut();
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(Dashboard.this, "Signed Out", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Dashboard.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
    }

//    private void revokeAccess() {
//        mGoogleSignInClient.revokeAccess()
//                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        // ...
//                    }
//                });
//    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//
//        if (firebaseAuthListener != null) {
//            mAuth.removeAuthStateListener(firebaseAuthListener);
//        }
//    }


}

