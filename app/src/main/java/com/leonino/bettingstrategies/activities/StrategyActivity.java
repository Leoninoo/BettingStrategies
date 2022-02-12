package com.leonino.bettingstrategies.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.leonino.bettingstrategies.R;
import com.leonino.bettingstrategies.models.Strategy;
import com.leonino.bettingstrategies.service.StrategyFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StrategyActivity extends AppCompatActivity {
    private boolean flagFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strategy);

        SharedPreferences preferences =
                this.getSharedPreferences("com.leonino.bettingstrategies", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        Set<String> favorites = new HashSet<>(preferences.getStringSet("favorites", new HashSet<>()));

        TextView nameView = findViewById(R.id.strategyFullName);
        TextView descriptionView = findViewById(R.id.strategyFullDescription);
        ImageView favoriteView = findViewById(R.id.favStrategy);
        ImageView closeView = findViewById(R.id.closeButton);

        String strName = getIntent().getStringExtra("stName");

        nameView.setText(strName);
        descriptionView.setText(StrategyFactory.getFullDescription(strName));

        flagFavorite = false;

        for(String fav : favorites) {
            if(fav.equals(strName)) {
                favoriteView.setImageResource(R.drawable.fav_ch);
                flagFavorite = true;
            }
        }


        favoriteView.setOnClickListener(view -> {
            if(flagFavorite) {
                flagFavorite = false;
                favoriteView.setImageResource(R.drawable.fav);

                favorites.removeIf(fav -> fav.equals(strName));

            }
            else {
                flagFavorite = true;
                favoriteView.setImageResource(R.drawable.fav_ch);

                favorites.add(strName);
            }
            editor.putStringSet("favorites", favorites);
            editor.apply();
        });

        closeView.setOnClickListener(view -> finish());
    }
}