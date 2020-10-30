package com.my.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rating {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	 private long movieId;
	    private String rating;

	    public Rating()
	    {
	    	
	    }
	    
	    public Rating(long movieId, String rating) {
	        this.movieId = movieId;
	        this.rating = rating;
	    }

	    public long getMovieId() {
	        return movieId;
	    }

	    public void setMovieId(long movieId) {
	        this.movieId = movieId;
	    }

	    public String getRating() {
	        return rating;
	    }

	    public void setRating(String rating) {
	        this.rating = rating;
	    }
	}