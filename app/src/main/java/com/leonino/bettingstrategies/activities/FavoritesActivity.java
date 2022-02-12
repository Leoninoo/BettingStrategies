package com.leonino.bettingstrategies.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.leonino.bettingstrategies.R;
import com.leonino.bettingstrategies.adapters.StrategiesAdapter;
import com.leonino.bettingstrategies.models.Strategy;
import com.leonino.bettingstrategies.service.StrategyFactory;

import java.util.List;

public class FavoritesActivity extends AppCompatActivity {
    private static List<Strategy> strategies;
    private static StrategiesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        strategies = StrategyFactory.getFavorites(this);

        adapter = new StrategiesAdapter(this, strategies, true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        RecyclerView strategiesList = findViewById(R.id.favoritesList);

        strategiesList.setLayoutManager(layoutManager);
        strategiesList.setAdapter(adapter);

        findViewById(R.id.goMain).setOnClickListener(view -> {
            finish();
        });
    }

    public static void deleteItem(String name) {
        int position = 0;
        for(int i = 0; i < strategies.size(); i++) {
            if(strategies.get(i).getName().equals(name)) {
                position = i;
                break;
            }
        }

        strategies.remove(position);
        adapter.notifyItemRemoved(position);
    }
}