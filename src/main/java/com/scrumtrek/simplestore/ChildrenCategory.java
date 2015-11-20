package com.scrumtrek.simplestore;

/**
 * Created by user on 19.11.2015.
 */
public class ChildrenCategory extends  OnePointCategoryBase {
    @Override
    public double CalculateAmount(int days) {
        final double amountPerDay = 1.5;
        final int actionDayCount = 3;
        if (days > actionDayCount) {
            return (days - actionDayCount) * amountPerDay;
        }
        return amountPerDay;
    }
}
