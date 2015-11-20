package com.scrumtrek.simplestore;

import java.util.Locale;

/**
 * Created by user on 20.11.2015.
 * more
 * more
 */
public class TextStatementGenerator implements IStatementGenerator {
    @Override
    public IStatement generate(Customer customer) {
        double totalAmount = 0;
        int totalPoints = 0;

        final StringBuilder result = new StringBuilder("Rental record for ").append(customer.getName())
                .append(System.lineSeparator());

        for (final Rental each : customer.getRentals()) {
            result.append(each);
            totalAmount += each.calculateAmount();
            totalPoints += each.calculatePoints();
        }

        // Add footer lines
        result.append(buildTotalStatement(totalAmount, totalPoints));
        return new TextStatement(result.toString());
    }

    private String buildTotalStatement(double totalAmount, int totalPoints) {
        return String.format(Locale.US, "Amount owed is %.1f%sYou earned %d frequent renter points.",
                totalAmount, System.lineSeparator(), totalPoints);
    }
}
