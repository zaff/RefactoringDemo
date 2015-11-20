package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private final transient String m_Name;
	private transient List<Rental> m_Rentals = new ArrayList<>();

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

		String result = "Rental record for " + m_Name + "\n";

		for (Rental each : m_Rentals) {

			Movie movie = each.getMovie();
			IRentalCategory category = movie.getRentalCategory();

			int days = each.getDaysRented();

			double amount = category.CalculateAmount(days);
			result += "\t" + movie.getTitle() + "\t" + amount + "\n";
			totalAmount += amount;
			totalPoints += category.CalculatePoints(days);
		}

		// Add footer lines
		result += "Amount owed is " + totalAmount + "\n";
		result += "You earned " + totalPoints + " frequent renter points.";
		return result;
	}
}

