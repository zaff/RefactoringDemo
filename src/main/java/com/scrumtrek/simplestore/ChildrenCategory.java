package com.scrumtrek.simplestore;

/**
 * Created by user on 19.11.2015.
 */
public class ChildrenCategory implements IRentalCategory {
    @Override
    public double CalculateAmount(int days) {

        double result = 1.5;
        if (days > 3) {
            return  (days - 3) * 1.5;
        }
        return result;
    }

    @Override
    public double CalculatePoints(int days) {
        return 1;
    }
}
