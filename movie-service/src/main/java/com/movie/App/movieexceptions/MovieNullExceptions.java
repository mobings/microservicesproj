package com.movie.App.movieexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MovieNullExceptions extends RuntimeException{
	
		    public MovieNullExceptions(String s) {
	        super(s);
	    }
	
	
	

}
