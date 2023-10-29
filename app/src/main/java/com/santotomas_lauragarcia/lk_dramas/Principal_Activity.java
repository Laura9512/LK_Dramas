package com.santotomas_lauragarcia.lk_dramas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;


public class Principal_Activity extends AppCompatActivity {

    CardView clothingCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        clothingCard = findViewById(R.id.clothingCard);
        clothingCard.setOnClickListener(view -> {
            Intent intent = new Intent(Principal_Activity.this, LoveActivity.class);
            startActivity(intent);
        });
    }
}