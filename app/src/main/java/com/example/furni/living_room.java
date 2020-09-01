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
import com.example.furni.helperClass.ItemAdapter_3;
import com.example.furni.helperClass.ItemAdapter_4;
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
    List<String> titles, titles_cushions, titles_oversidechairs,titles_seatlift;
    List<Integer> images, images_cushions, image_oversidechairs, image_seatlift;
    List<Integer> link;
    RecyclerView chair_raisers_list, cushions_list, oversidetable_list, seatlift_list;
    ItemAdapter adapter_1;
    ItemAdapter_2 adapter_2;
    ItemAdapter_3 adapter_3;
    ItemAdapter_4 adapter_4;


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
        oversidetable_list = findViewById(R.id.chairsidetables_layout);
        seatlift_list = findViewById(R.id.seatliftassist_layout);
        naviagtionDrawer();

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        titles = new ArrayList<>();
        images = new ArrayList<>();
        link = new ArrayList<>();

        titles.add("Slipstick CB652 3 Inch");
        titles.add("Round Plastic Legs");
        titles.add("Round Stand ");
        titles.add("All in one");
        titles.add("Legs/ Stand");


        images.add(R.drawable.slipstick);
        images.add(R.drawable.round);
        images.add(R.drawable.sellify);
        images.add(R.drawable.allinone);
        images.add(R.drawable.smallsize);


        adapter_1 = new ItemAdapter(this, titles,images);



//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.HORIZONTAL,false);

//        chair_raisers_list.setLayoutManager(gridLayoutManager);
        chair_raisers_list.setLayoutManager(new LinearLayoutManager(this, LinearLayout.HORIZONTAL, false));
        chair_raisers_list.setAdapter(adapter_1);


        cushions_recycler();
        oversidechair_recycler();
        seatlift_recycler();

    }

    private void cushions_recycler() {

        titles_cushions = new ArrayList<>();
        images_cushions = new ArrayList<>();

        cushions_list.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));



        titles_cushions.add("Wedge Seat Cushion");
        titles_cushions.add("Pump Cushion");
        titles_cushions.add("Coccyx Cushion");
        titles_cushions.add("Neck Pillow");
        titles_cushions.add("Seat Flex Pillow");
        titles_cushions.add("Ring Pillow");
        titles_cushions.add("Gel comfort");

        images_cushions.add(R.drawable.memorycushion);
        images_cushions.add(R.drawable.pumpcushion);
        images_cushions.add(R.drawable.coccyxcushion);
        images_cushions.add(R.drawable.neckpillow);
        images_cushions.add(R.drawable.seatflex);
        images_cushions.add(R.drawable.ringpillow);
        images_cushions.add(R.drawable.gelcomfort);

        adapter_2 = new ItemAdapter_2(this,titles_cushions,images_cushions);
        cushions_list.setAdapter(adapter_2);

    }

    private void oversidechair_recycler() {

        titles_oversidechairs = new ArrayList<>();
        image_oversidechairs = new ArrayList<>();

        oversidetable_list.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));



        titles_oversidechairs.add("Swivel Desk Table");
        titles_oversidechairs.add("Adjustable Table");
        titles_oversidechairs.add("Wooden Desk");
        titles_oversidechairs.add("Multipurpose Desk");

        image_oversidechairs.add(R.drawable.desktable);
        image_oversidechairs.add(R.drawable.portablelaptop);
        image_oversidechairs.add(R.drawable.woodendesk);
        image_oversidechairs.add(R.drawable.bedtable);



        adapter_3 = new ItemAdapter_3(this,titles_oversidechairs,image_oversidechairs);
        oversidetable_list.setAdapter(adapter_3);

    }

    private void seatlift_recycler() {

        titles_seatlift = new ArrayList<>();
        image_seatlift = new ArrayList<>();

        seatlift_list.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));



        titles_seatlift.add("Seat Lift Assist");


        image_seatlift.add(R.drawable.seatassist);



        adapter_4 = new ItemAdapter_4(this,titles_seatlift,image_seatlift);
        seatlift_list.setAdapter(adapter_4);

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