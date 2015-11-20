package com.scrumtrek.simplestore;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Customer {
    private final transient String m_Name;
    private final transient List<Rental> m_Rentals = new ArrayList<>();

    public Customer(String name) {
        m_Name = name;
    }

    public String getName() {
        return m_Name;
    }


    public void addRental(Rental arg) {
        m_Rentals.add(arg);
    }

    public String Statement() {
        double totalAmount = 0;
        int totalPoints = 0;

        StringBuilder result = new StringBuilder("Rental record for ").append(m_Name).append("\n");

        for (Rental each : m_Rentals) {

            Movie movie = each.getMovie();
            IRentalCategory category = movie.getRentalCategory();

            int days = each.getDaysRented();

            double amount = category.CalculateAmount(days);
            result.append(String.format(Locale.US, "\t%s\t%.1f\n", movie.getTitle(), amount));
            totalAmount += amount;
            totalPoints += category.CalculatePoints(days);
        }

        // Add footer lines
        result.append(String.format(Locale.US, "Amount owed is %.1f\n", totalAmount))
                .append(String.format("You earned %d frequent renter points.", totalPoints));
        return result.toString();
    }
}

