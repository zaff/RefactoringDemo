package com.scrumtrek.simplestore;

public class Movie {
	private transient final String m_Title;
	private transient final IRentalCategory m_RentalCategory;

	public Movie(String title, IRentalCategory rentalCategory) {
		m_Title = title;
		m_RentalCategory = rentalCategory;
	}

	public IRentalCategory getRentalCategory() {
		return m_RentalCategory;
	}

	public String getTitle() {
		return m_Title;
	}
}

