package com.scrumtrek.simplestore;

/**
 * Created by user on 19.11.2015.
 */
public class RegularCategory extends RentalCategoryBase {
    /* default */ private static final double AMOUNT_PER_DAY = 2;
    /* default */ private static final int ACTION_DAY_COUNT = 2;

    @Override
    public double calculateAmount(int days) {
        if (days > ACTION_DAY_COUNT) {
            return AMOUNT_PER_DAY + (days - ACTION_DAY_COUNT) * 1.5;
        }
        return AMOUNT_PER_DAY;
    }
}
