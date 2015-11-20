package com.scrumtrek.simplestore;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 19.11.2015.
 *
 * * more
 * more
 */
public class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public List<Rental> getRentals(){
        return rentals;
    }

    public String getName(){
        return name;
    }
}

