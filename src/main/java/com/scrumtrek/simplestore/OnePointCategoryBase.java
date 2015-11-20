package com.scrumtrek.simplestore;

/**
 * Created by user on 19.11.2015.
 */
public abstract class OnePointCategoryBase implements IRentalCategory {
    @Override
    public double CalculatePoints(int days) {
        return 1;
    }
}
