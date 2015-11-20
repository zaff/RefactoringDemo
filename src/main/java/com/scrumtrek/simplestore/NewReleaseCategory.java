package com.scrumtrek.simplestore;

/**
 * Created by user on 19.11.2015.
 */
public class NewReleaseCategory implements IRentalCategory {
    /* default */ private static final double AMOUNT_PER_DAY = 3;
    /* default */ private static final int BONUS_POINTS = 2;
    @Override
    public double CalculateAmount(int days) {
        return days * AMOUNT_PER_DAY;
    }

    @Override
    public double CalculatePoints(int days) {
        if (days > 1)
        {
            return BONUS_POINTS;
        }
        return IRentalCategory.super.CalculatePoints(days);
    }
}
