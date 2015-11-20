package com.scrumtrek.simplestore;

public class Movie {
	private final transient String title;
	private final transient IRentalCategory rentalCategory;

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

