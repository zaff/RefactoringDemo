package com.scrumtrek.simplestore;

/**
 * Created by user on 19.11.2015.
 */
public class NewRealeseCategory implements IRentalCategory {
    @Override
    public double CalculateAmount(int days) {
        return days * 3;
    }

    @Override
    public double CalculatePoints(int days) {

        return days > 1 ? 2 : 1;
    }
}
