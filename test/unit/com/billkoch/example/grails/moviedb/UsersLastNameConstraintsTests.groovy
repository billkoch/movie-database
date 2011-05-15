package com.billkoch.example.grails.moviedb;

import grails.test.GrailsUnitTestCase;

class UserLastNameConstraints extends GrailsUnitTestCase {

	protected void setUp() {
        super.setUp()
		mockForConstraintsTests(User)
    }

    protected void tearDown() {
        super.tearDown()
    }
	
	void testAUsersLastNameCannotBeLessThanTwoCharacters() {
		def user = new User(lastName: 'A')
		
		assertFalse(user.validate())
		assertEquals('size', user.errors['lastName'])
	}
	
	void testAUsersLastNameCannotBeMoreThanFiftyCharacters() {
		def user = new User(lastName:'ThisLasttNameIsAnExampleOfALastNameThatShouldBeConsideredTooLong')
		
		assertFalse(user.validate())
		assertEquals('size', user.errors['lastName'])
	}
	
	void testAUsersLastNameIsValidIfItOnlyContainsAlphabeticCharacters() {
		def user = new User(lastName:'AValidLastName', firstName:'AValidFirstName', userName:'AValidUserName')
		
		assertTrue(user.validate())
	}
	
	void testAUsersLastNameIsInvalidIfItContainsNumericCharacters() {
		def user = new User(lastName:'Th1s1s1nval1d')
		
		assertFalse(user.validate())
		assertEquals('matches', user.errors['lastName'])
	}
	
	void testAUsersLastNameIsInvalidIfItContainsSymbols() {
		def user = new User(lastName:'$%_#^')
		
		assertFalse(user.validate())
		assertEquals('matches', user.errors['lastName'])
	}
	
	void testAUsersLastNameCanContainASingleApostropheCharacter() {
		def user = new User(lastName:"O'Brien", firstName:'AValidFirstName', userName:'AValidUserName')
		
		assertTrue(user.validate())
	}
	
	void testAUsersLastNameCanContainASingleHyphenCharacter() {
		def user = new User(lastName:"Smith-Jones", firstName:'AValidFirstName', userName:'AValidUserName')
		
		assertTrue(user.validate())
	}
}
