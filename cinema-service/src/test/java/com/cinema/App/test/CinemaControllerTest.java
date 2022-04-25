package com.cinema.App.test;

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
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.cinema.App.controller.*;

import com.cinema.App.model.*;
import com.cinema.App.repository.CinemaRepository;

@SpringBootTest()
@AutoConfigureMockMvc()
public class CinemaControllerTest {

	@Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
	
	
    @MockBean
    CinemaRepository	cinemaRepository ;
    

    
    Cinema mov1 = new Cinema("cinema1","City1","10/08/2021", 1,1700);
    Cinema mov2 = new Cinema("cinema1","City1","10/06/2021", 2,1600);
    Cinema mov3 = new Cinema("cinema1","City1","10/07/2021", 1,1600) ;
    
    		
    		
    
    
	
	@Test
	public void testGetAllcinemas() throws Exception {
		List<Cinema> records = new ArrayList<>(Arrays.asList(mov1, mov2, mov3));
	    
	    Mockito.when(cinemaRepository.findAll()).thenReturn(records);
	    
	    mockMvc.perform(MockMvcRequestBuilders
	            .get("/cinemas")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            
	        ;    
	}
	}


