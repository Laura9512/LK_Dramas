package com.santotomas_lauragarcia.lk_dramas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {

    EditText signupName, signupEmail, signupUsername, signupPassword;
    TextView loginRedirectText;
    Button signupButton;
    FirebaseDatabase database;

    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signupName = findViewById(R.id.signup_name);
        signupEmail = findViewById(R.id.signup_email);
        signupUsername = findViewById(R.id.signup_username);
        signupPassword = findViewById(R.id.signup_password);
        signupButton = findViewById(R.id.signup_button);
        loginRedirectText = findViewById(R.id.loginRedirectText);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");

                String name = signupName.getText().toString();
                String email = signupEmail.getText().toString();
                String username = signupUsername.getText().toString();
                String password = signupPassword.getText().toString();

                Helper helper = new Helper(name, email, username, password);
                reference.child(name).setValue(helper);

                Toast.makeText( Signup.this, "Te has registrado!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Signup.this, Login.class);
                startActivity(intent);

            }

        });

        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signup.this, Login.class);
                startActivity(intent);

            }
        });
    }

    public static class Principal_Activity extends AppCompatActivity {
        CardView clothingCard, bof, yab, empress, pfk, sdd;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_principal);
            clothingCard = findViewById(R.id.clothingCard);
            clothingCard.setOnClickListener(view -> {
                Intent intent = new Intent(Principal_Activity.this, Amd_Activity.class);
                startActivity(intent);


            });

            bof = findViewById(R.id.bof);
            bof.setOnClickListener(view -> {
                Intent intent = new Intent(Principal_Activity.this, Bof_Activity.class);
                startActivity(intent);


            });

            yab = findViewById(R.id.yab);
            yab.setOnClickListener(view -> {
                Intent intent = new Intent(Principal_Activity.this, Yab_Activity.class);
                startActivity(intent);


            });

            empress = findViewById(R.id.empress);
            empress.setOnClickListener(view -> {
                Intent intent = new Intent(Principal_Activity.this, Empress_Activity.class);
                startActivity(intent);


            });

            sdd = findViewById(R.id.sdd);
            sdd.setOnClickListener(view -> {
                Intent intent = new Intent(Principal_Activity.this, Sdd_Activity.class);
                startActivity(intent);


            });

            pfk = findViewById(R.id.pfk);
            pfk.setOnClickListener(view -> {
                Intent intent = new Intent(Principal_Activity.this, Pfk_Activity.class);
                startActivity(intent);


            });





            BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
            bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
                if (item.getItemId() == R.id.btn_location) {
                    Intent intent = new Intent(Principal_Activity.this, Mapa.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            });

        }

    }
}