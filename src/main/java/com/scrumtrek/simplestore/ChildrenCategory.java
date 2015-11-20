package com.scrumtrek.simplestore;

/**
 * Created by user on 19.11.2015.
 */
public class ChildrenCategory extends  OnePointCategoryBase {
    final transient double amountPerDay = 1.5;
    final transient int actionDayCount = 3;

    @Override
    public double CalculateAmount(int days) {
        if (days > actionDayCount) {
            return (days - actionDayCount) * amountPerDay;
        }
        return amountPerDay;
    }
}
