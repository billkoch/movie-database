package com.billkoch.example.grails.moviedb

class User {

	String userName
	String firstName
	String lastName
	
    static constraints = {
		userName(minSize:8, maxSize:15)
		firstName(size:2..50, matches:'[a-zA-Z]+')
		lastName(size:2..50, matches:"([a-zA-Z]['])?[a-zA-Z]+(-)?[a-zA-Z]+")
    }
}
