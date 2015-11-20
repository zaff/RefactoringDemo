package com.scrumtrek.simplestore;

/**
 * Created by user on 19.11.2015.
 *
 * * more
 * more
 */
public abstract class RentalCategoryBase implements IRentalCategory {
    /* default */ private static final int DEFAULT_POINTS = 1;

    @Override
    public double calculatePoints(int days) {
        return DEFAULT_POINTS;
    }
}
