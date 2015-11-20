package com.scrumtrek.simplestore;

/**
 * Created by user on 19.11.2015.
 */
@FunctionalInterface
public interface IRentalCategory {
    double calculateAmount(int days);

    default double calculatePoints(int days) {
        return 1;
    }
}
