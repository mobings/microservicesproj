package com.movie.App.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movie.App.controller.MovieController;
import com.movie.App.model.Movie;
import com.movie.App.repository.MovieRepository;
@WebMvcTest(MovieController.class)
public class MovieControllerTest {

	@Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
	
	
    @MockBean
    MovieRepository	movieRepository ;
    
    Movie mov1 = new Movie("Movie1","Movie1 desc", true);
    Movie mov2 = new Movie("Movie2","Movie2 desc", true);
    Movie mov3 = new Movie("Movie3","Movie3 desc", true);
    
    
	
	@Test
	public void testGetAllmovies() throws Exception {
		List<Movie> records = new ArrayList<>(Arrays.asList(mov1, mov2, mov3));
	    
	    Mockito.when(movieRepository.findAll()).thenReturn(records);
	    
	    mockMvc.perform(MockMvcRequestBuilders
	            .get("/movies")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            
	        ;    
	}
	}


