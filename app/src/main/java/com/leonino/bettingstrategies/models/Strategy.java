package com.leonino.bettingstrategies.models;

public class Strategy {
    private final String name;
    private final String description;

    private boolean isFavorite;

    public Strategy(String name, String description) {
        this.name = name;
        this.description = description;
        isFavorite = false;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
