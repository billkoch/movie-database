package com.billkoch.example.grails.moviedb

import grails.test.GrailsUnitTestCase

class UsersUserNameConstraintsTestTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
		mockForConstraintsTests(User)
    }

    protected void tearDown() {
        super.tearDown()
    }
	
	void testAUsersUserNameCannotBeLessThanEightCharactersLong() {
		def user = new User(userName:'1234567', firstName:'AValidFirstName', lastName:'AValidLastName')
		
		assertFalse(user.validate())
	}
	
	void testAUsersUserNameCannotBeMoreThanFifteenCharactersLong() {
		def user = new User(userName:'ThisIsTooLong123', firstName:'AValidFirstName', lastName:'AValidLastName')
		
		assertFalse(user.validate())
	}
}
