package com.billkoch.example.grails.moviedb

import grails.test.GrailsUnitTestCase

class MovieConstraintsTest extends GrailsUnitTestCase {

	protected void setUp() {
		super.setUp()
		mockForConstraintsTests(Movie)
	}

	protected void tearDown() {
		super.tearDown()
	}

	void testAReleaseDateIsNullable() {
		def movie = new Movie(releaseDate:null, title:'A Valid Movie Title')
		assertTrue(movie.validate())
	}

	void testATitleMustBeAtLeastOneCharacterLong() {
		def movie = new Movie(title:'')
		assertFalse(movie.validate())
	}
	
	void testATitleCannotBeMoreThanFiftyCharactersLong() {
		def movie = new Movie(title:'This is a really long title that should be invalid.')
		assertFalse(movie.validate())
	}
}
