package com.scrumtrek.simplestore;

/**
 * Created by user on 19.11.2015.
 */
public class NewRealeseCategory implements IRentalCategory {
    /* default */ final static double amountPerDay = 3;
    @Override
    public double CalculateAmount(int days) {
        return days * amountPerDay;
    }

    @Override
    public double CalculatePoints(int days) {
        if (days > 1) return 2;
        return 1;
    }
}
