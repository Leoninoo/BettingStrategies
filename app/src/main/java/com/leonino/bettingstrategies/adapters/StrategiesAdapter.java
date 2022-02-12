package com.leonino.bettingstrategies.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.leonino.bettingstrategies.R;
import com.leonino.bettingstrategies.activities.FavoritesActivity;
import com.leonino.bettingstrategies.activities.StrategyActivity;
import com.leonino.bettingstrategies.models.Strategy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StrategiesAdapter extends RecyclerView.Adapter<StrategiesAdapter.StrategiesHolder> {
    private final Context context;
    private final List<Strategy> strategies;
    private final boolean isFavorite;

    public StrategiesAdapter(Context context, List<Strategy> strategies, boolean isFavorite) {
        this.context = context;
        this.strategies = strategies;
        this.isFavorite = isFavorite;
    }

    @NonNull
    @Override
    public StrategiesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_betting, parent, false);
        return new StrategiesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StrategiesHolder holder, int position) {
        Strategy strategy = strategies.get(position);

        holder.stName.setText(strategy.getName());
        holder.stDescription.setText(strategy.getDescription());

        if(strategy.isFavorite()) {
            holder.stFav.setImageResource(R.drawable.fav_ch);
        }

        holder.more.setOnClickListener(view -> {
            Intent intent = new Intent(context, StrategyActivity.class);
            intent.putExtra("stName", strategies.get(position).getName());

            context.startActivity(intent);
        });

        SharedPreferences preferences =
                context.getSharedPreferences("com.leonino.bettingstrategies", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        holder.stFav.setOnClickListener(view -> {
            Set<String> favorites = new HashSet<>(preferences.getStringSet("favorites", new HashSet<>()));

            if(strategy.isFavorite()) {
                strategy.setFavorite(false);
                holder.stFav.setImageResource(R.drawable.fav);

                favorites.removeIf(fav -> fav.equals(strategy.getName()));

                if(isFavorite)
                    FavoritesActivity.deleteItem(strategy.getName());
            }
            else {
                strategy.setFavorite(true);
                holder.stFav.setImageResource(R.drawable.fav_ch);

                favorites.add(strategy.getName());

            }
            editor.putStringSet("favorites", favorites);
            editor.apply();
        });
    }

    @Override
    public int getItemCount() {
        return strategies.size();
    }

    protected static final class StrategiesHolder extends RecyclerView.ViewHolder {
        private final TextView stName;
        private final TextView stDescription;
        private final ImageView stFav;
        private final Button more;

        public StrategiesHolder(@NonNull View itemView) {
            super(itemView);

            stName = itemView.findViewById(R.id.strategyName);
            stDescription = itemView.findViewById(R.id.strategyDescriptionShort);
            stFav = itemView.findViewById(R.id.fav);
            more = itemView.findViewById(R.id.buttonMore);
        }
    }
}
