package com.scrumtrek.simplestore;

/**
 * Created by user on 19.11.2015.
 */
public class NewRealeseCategory implements IRentalCategory {
    @Override
    public double CalculateAmount(int days) {
        return days * 3.0;
    }

    @Override
    public double CalculatePoints(int days) {

        if (days > 1) return 2;
        else return 1;
    }
}
