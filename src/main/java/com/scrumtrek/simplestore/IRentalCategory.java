package com.scrumtrek.simplestore;

/**
 * Created by user on 19.11.2015.
 */
public interface IRentalCategory {
    double CalculateAmount(int days);

    default double CalculatePoints(int days) {
        return 1;
    }
}
