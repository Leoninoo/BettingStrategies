package com.leonino.bettingstrategies.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.leonino.bettingstrategies.R;
import com.leonino.bettingstrategies.adapters.StrategiesAdapter;
import com.leonino.bettingstrategies.models.Strategy;
import com.leonino.bettingstrategies.service.StrategyFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences preferences;
    private List<Strategy> strategies;
    private StrategiesAdapter adapter;
    private RecyclerView strategiesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        strategies = StrategyFactory.getStrategies();
        preferences = this.getSharedPreferences("com.leonino.bettingstrategies", Context.MODE_PRIVATE);

        setFavorites();

        adapter = new StrategiesAdapter(this, strategies, false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        strategiesList = findViewById(R.id.strategiesList);

        strategiesList.setLayoutManager(layoutManager);
        strategiesList.setAdapter(adapter);

        findViewById(R.id.favorites).setOnClickListener(view -> {
            startActivity(new Intent(this, FavoritesActivity.class));
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        setFavorites();
        adapter = new StrategiesAdapter(this, strategies, false);
        strategiesList.setAdapter(adapter);
    }

    private void setFavorites() {
        Set<String> favorites = preferences.getStringSet("favorites", new HashSet<>());

        for(Strategy strategy : strategies) {
            boolean flag = false;
            for(String fav : favorites) {
                if(fav.equals(strategy.getName())) {
                    flag = true;
                    break;
                }
            }
            strategy.setFavorite(flag);
        }
    }
}