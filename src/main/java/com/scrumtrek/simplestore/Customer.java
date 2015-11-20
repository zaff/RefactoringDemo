package com.scrumtrek.simplestore;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Customer {
    private final transient String name;
    private final transient List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String Statement() {
        double totalAmount = 0;
        int totalPoints = 0;

        StringBuilder result = new StringBuilder("Rental record for ").append(name).append(System.lineSeparator());

        for (final Rental each : rentals) {
            final Movie movie = each.getMovie();
            final IRentalCategory category = movie.getRentalCategory();
            final int days = each.getDaysRented();
            final double amount = category.CalculateAmount(days);

            result.append(String.format(Locale.US, "\t%s\t%.1f%s", movie.getTitle(), amount, System.lineSeparator()));
            totalAmount += amount;
            totalPoints += category.CalculatePoints(days);
        }

        // Add footer lines
        result.append(String.format(Locale.US, "Amount owed is %.1f%s", totalAmount, System.lineSeparator()))
                .append(String.format("You earned %d frequent renter points.", totalPoints));
        return result.toString();
    }
}

