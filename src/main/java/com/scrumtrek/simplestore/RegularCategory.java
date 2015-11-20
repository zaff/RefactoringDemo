package com.scrumtrek.simplestore;

/**
 * Created by user on 19.11.2015.
 */
public class RegularCategory extends OnePointCategoryBase {
    final static transient double amountPerDay = 2;
    final static transient int actionDayCount = 2;

    @Override
    public double CalculateAmount(int days) {
        if (days > actionDayCount) {
            return amountPerDay + (days - actionDayCount) * 1.5;
        }
        return amountPerDay;
    }
}
