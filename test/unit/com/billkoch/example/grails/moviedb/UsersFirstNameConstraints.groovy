package com.billkoch.example.grails.moviedb

import grails.test.GrailsUnitTestCase

class UsersFirstNameConstraints extends GrailsUnitTestCase {
	
    protected void setUp() {
        super.setUp()
		mockForConstraintsTests(User)
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testAUsersFirstNameCannotBeLessThanTwoCharacters() {
		def user = new User(firstName: 'A')
		
		assertFalse(user.validate())
		assertEquals('size', user.errors['firstName'])
	}
	
	void testAUsersFirstNameCannotBeMoreThanFiftyCharacters() {
		def user = new User(firstName:'ThisFirstNameIsAnExampleOfAFirstNameThatShouldBeConsideredTooLong')
		
		assertFalse(user.validate())
		assertEquals('size', user.errors['firstName'])
	}
	
	void testAUsersFirstNameIsValidIfItOnlyContainsAlphabeticCharacters() {
		def user = new User(firstName:'AValidFirstName', lastName:'AValidLastName', userName:'AValidUserName')
		
		assertTrue(user.validate())
	}
	
	void testAUsersFirstNameIsInvalidIfItContainsNumericCharacters() {
		def user = new User(firstName:'Th1s1s1nval1d')
		
		assertFalse(user.validate())
		assertEquals('matches', user.errors['firstName'])
	}
	
	void testAUsersFirstNameIsInvalidIfItContainsSymbols() {
		def user = new User(firstName:'$%_#^')
		
		assertFalse(user.validate())
		assertEquals('matches', user.errors['firstName'])
	}
}
