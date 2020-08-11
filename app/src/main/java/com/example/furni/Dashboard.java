package com.example.furni;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Dashboard extends AppCompatActivity {

    ImageView signout;
    FirebaseAuth mAuth;
    GoogleSignInClient mGoogleSignInClient;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;

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
//        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
//        if (acct != null) {
//            String personName = acct.getDisplayName();
//
//            String personEmail = acct.getEmail();
//
//            Uri personPhoto = acct.getPhotoUrl();
//
//            name.setText(personName);
//            email.setText(personEmail);
//            Glide.with(this).load(String.valueOf(personPhoto)).into(imageView);
//        }
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

