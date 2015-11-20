package com.scrumtrek.simplestore;

/**
 * Created by user on 19.11.2015.
 */
public class NewReleaseCategory implements IRentalCategory {
    /* default */ private static final double AMOUNT_PER_DAY = 3;
    /* default */ private static final int BONUS_POINTS = 2;
    @Override
    public double calculateAmount(int days) {
        return days * AMOUNT_PER_DAY;
    }

    @Override
    public double calculatePoints(int days) {
        if (days > 1)
        {
            return BONUS_POINTS;
        }
        return IRentalCategory.super.calculatePoints(days);
    }
}
