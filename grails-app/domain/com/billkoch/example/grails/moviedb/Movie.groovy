package com.billkoch.example.grails.moviedb

class Movie {

	String title
	Date releaseDate
	
    static constraints = {
		title(blank:false, maxSize:50)
		releaseDate(nullable:true)
    }
}
