package com.scrumtrek.simplestore;

/**
 * Created by user on 19.11.2015.
 *
 * * more
 * more
 */
public class Movie {
    private final String title;
    private final IRentalCategory rentalCategory;

    public Movie(String title, IRentalCategory rentalCategory) {
        this.title = title;
        this.rentalCategory = rentalCategory;
    }

    public IRentalCategory getRentalCategory() {
        return rentalCategory;
    }

    public String getTitle() {
        return title;
    }
}

