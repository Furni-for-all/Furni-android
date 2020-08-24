package com.example.furni;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.furni.helperClass.AdapterLegs;
import com.example.furni.helperClass.ItemAdapter;
import com.example.furni.helperClass.ItemAdapter_2;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class living_room extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    static final float END_SCALE = 0.7f;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView navigation_header_icon;
    RelativeLayout contentView;
    GoogleSignInClient mGoogleSignInClient;
    List<String> titles, titles_cushions;
    List<Integer> images, images_cushions;
    RecyclerView chair_raisers_list, cushions_list;
    ItemAdapter adapter_1;
    ItemAdapter_2 adapter_2;


    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_living_room);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigation_header_icon = findViewById(R.id.navigation_header_icon);
        contentView = findViewById(R.id.content);
        chair_raisers_list = findViewById(R.id.chair_raisers_layout);
        cushions_list = findViewById(R.id.cushions_layout);
        naviagtionDrawer();

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        titles = new ArrayList<>();

        images = new ArrayList<>();

        titles.add("Slipstick CB652 3 Inch");
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



        adapter_1 = new ItemAdapter(this, titles,images);

        cushions_recycler();
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.HORIZONTAL,false);

//        chair_raisers_list.setLayoutManager(gridLayoutManager);
        chair_raisers_list.setLayoutManager(new LinearLayoutManager(this, LinearLayout.HORIZONTAL, false));

        chair_raisers_list.setAdapter(adapter_1);


    }

    private void cushions_recycler() {

        titles_cushions = new ArrayList<>();
        images_cushions = new ArrayList<>();

        cushions_list.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));



        titles_cushions.add("Coccyx Cushion");
        titles_cushions.add("Coccyx Cushion");
        titles_cushions.add("Coccyx Cushion");
        titles_cushions.add("Coccyx Cushion");

        images_cushions.add(R.drawable.background);
        images_cushions.add(R.drawable.background);
        images_cushions.add(R.drawable.background);
        images_cushions.add(R.drawable.background);

        adapter_2 = new ItemAdapter_2(this,titles_cushions,images_cushions);
        cushions_list.setAdapter(adapter_2);

    }

    //navigation drawer functions
    private void naviagtionDrawer() {

        //Naviagtion Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.item1);

        navigation_header_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        animateNavigationDrawer();
    }

    private void animateNavigationDrawer() {

        //Add any color or remove it to use the default one!
        //To make it transparent use Color.Transparent in side setScrimColor();
        //drawerLayout.setScrimColor(Color.TRANSPARENT);
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });

    }

    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item1:
//                Toast.makeText(this, "Item 1 selected", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(living_room.this, Dashboard.class);
                startActivity(intent);
                return true;
            case R.id.item2:
                Toast.makeText(this, "Item 2 selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:
                Toast.makeText(this, "Item 3 selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.nav_logout:
                Toast.makeText(this, "Logout Successful", Toast.LENGTH_SHORT).show();
                FirebaseAuth.getInstance().signOut();

                signOut();
                break;
            default:
                break;
        }
        return true;
    }
    private void signOut() {
        FirebaseAuth.getInstance().signOut();
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(living_room.this, "Signed Out", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(living_room.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
    }

}