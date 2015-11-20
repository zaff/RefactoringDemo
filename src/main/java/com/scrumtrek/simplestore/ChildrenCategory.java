package com.scrumtrek.simplestore;

/**
 * Created by user on 19.11.2015.
 */
public class ChildrenCategory extends RentalCategoryBase {
    /* default */ private static final double AMOUNT_PER_DAY = 1.5;
    /* default */ private static final int ACTION_DAY_COUNT = 3;

    @Override
    public double calculateAmount(int days) {

        if (days > ACTION_DAY_COUNT) {
            return (days - ACTION_DAY_COUNT) * AMOUNT_PER_DAY;
        }
        return AMOUNT_PER_DAY;
    }
}
