package com.scrumtrek.simplestore;

/**
 * Created by user on 19.11.2015.
 */
public class RegularCategory implements IRentalCategory {
    @Override
    public double CalculateAmount(int days) {
        double result = 2;
        if (days > 2) {
            result += (days - 2) * 1.5;
        }
        return result;
    }

    @Override
    public double CalculatePoints(int days) {
        return 1;
    }
}
