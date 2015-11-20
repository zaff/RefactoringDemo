package com.scrumtrek.simplestore;

/**
 * Created by user on 19.11.2015.
 */
public class ChildrenCategory implements IRentalCategory {
    /* default */ private final static double amountPerDay = 1.5;
    /* default */ private final static int actionDayCount = 3;

    @Override
    public double CalculateAmount(int days) {

        if (days > actionDayCount) {
            return (days - actionDayCount) * amountPerDay;
        }
        return amountPerDay;
    }
}
