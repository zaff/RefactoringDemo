package com.scrumtrek.simplestore;

import java.util.Locale;

public class Rental {
    private final Movie movie;
    private final int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public double calculatePoints(){
        return movie.getRentalCategory().calculatePoints(daysRented);
    }

    public double calculateAmount(){
        return movie.getRentalCategory().calculateAmount(daysRented);
    }
    
    @Override
    public String toString() {
        return String.format(Locale.US, "\t%s\t%.1f%s", movie.getTitle(),
                calculateAmount(), System.lineSeparator());
    }
}

