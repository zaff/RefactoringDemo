package com.scrumtrek.simplestore;

/**
 * Created by user on 19.11.2015.
 *
 * more
 */

public interface IRentalCategory {
    double calculateAmount(int days);
    double calculatePoints(int days);
}
