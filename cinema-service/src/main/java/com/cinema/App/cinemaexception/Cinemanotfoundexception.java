package com.cinema.App.cinemaexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class Cinemanotfoundexception extends RuntimeException
{
    /**
     * Constructs a new runtime exception with the specified detail message.
     */
    public Cinemanotfoundexception(String message)
    {
        super(message);
    }
}
