package com.scrumtrek.simplestore;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String buildStatement() {
        double totalAmount = 0;
        int totalPoints = 0;

        final StringBuilder result = new StringBuilder("Rental record for ").append(name)
                .append(System.lineSeparator());

        for (final Rental each : rentals) {
            result.append(each);
            totalAmount += each.calculateAmount();
            totalPoints += each.calculatePoints();
        }

        // Add footer lines
        result.append(buildTotalStatement(totalAmount, totalPoints));
        return result.toString();
    }

    public String buildTotalStatement(double totalAmount, int totalPoints) {
        return String.format(Locale.US, "Amount owed is %.1f%sYou earned %d frequent renter points.",
                totalAmount, System.lineSeparator(), totalPoints);
    }
}

