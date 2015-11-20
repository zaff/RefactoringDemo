package com.scrumtrek.simplestore;

/**
 * Created by user on 19.11.2015.
 *
 * more
 */
public class NewReleaseCategory extends RentalCategoryBase {
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
        return super.calculatePoints(days);
    }
}
