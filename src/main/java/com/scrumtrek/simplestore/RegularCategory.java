package com.scrumtrek.simplestore;

/**
 * Created by user on 19.11.2015.
 */
public class RegularCategory extends OnePointCategoryBase {
    private final static double amountPerDay = 2;
    private final static int actionDayCount = 2;

    @Override
    public double CalculateAmount(int days) {
        if (days > actionDayCount) {
            return amountPerDay + (days - actionDayCount) * 1.5;
        }
        return amountPerDay;
    }
}
