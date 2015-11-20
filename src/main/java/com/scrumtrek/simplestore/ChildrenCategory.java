package com.scrumtrek.simplestore;

/**
 * Created by user on 19.11.2015.
 */
public class ChildrenCategory extends  OnePointCategoryBase {
    /* default */ final static double amountPerDay = 1.5;
    /* default */ final static int actionDayCount = 3;

    @Override
    public double CalculateAmount(int days) {

        if (days > actionDayCount) {
            return (days - actionDayCount) * amountPerDay;
        }
        return amountPerDay;
    }
}
