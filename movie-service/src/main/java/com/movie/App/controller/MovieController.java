package com.movie.App.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.movie.App.feignclients.CinemaFeignClient;
import com.movie.App.model.Cinema;
import com.movie.App.model.Movie;

import com.movie.App.movieexceptions.MovieNullExceptions;
import com.movie.App.repository.MovieRepository;

import javassist.NotFoundException;

@RestController
@RefreshScope

public class MovieController {

	
	
	@Autowired
	MovieRepository movieRepository;
	@Autowired
	private CinemaFeignClient feigncinema;
	@Autowired
	Confprop conf;

	@GetMapping("/movies")
	public ResponseEntity<List<Movie>> getAllmovies(@RequestParam(required = false) String title) {
		try {
			List<Movie> movies = new ArrayList<Movie>();

			
			  if (title == null) movieRepository.findAll().forEach(movies::add);
			  
			  else movieRepository.findByTitleContaining(title).forEach(movies::add);
			 
			if (movies.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(movies, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/movies/{id}")
	public ResponseEntity<Movie> getmovieById(@PathVariable("id") long id)  {
		Optional<Movie> movieData = movieRepository.findById(id);

		if (movieData.isPresent()) {
			return new ResponseEntity<>(movieData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

	
	
	@GetMapping("/movies/cinemas/{id}")
	public List<Cinema> getcinemaByMovieId(@PathVariable("id") long id) {
		//List<Cinema> cinemas = new ArrayList<Cinema>();
		return feigncinema.getcinemaByMovieId(id);
			
		
	}
	
    @GetMapping("/message")
    String getMsg() {
        return "from movie:"+conf.getusername() ;
    }
	
	
	
	@PostMapping("/movies")
	public ResponseEntity<Movie> createmovie(@RequestBody Movie movie) {
		try {
			Movie _movie = movieRepository
					.save(new Movie(movie.getTitle(), movie.getDescription(), movie.isReleased()));
			return new ResponseEntity<>(_movie, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/movies/{id}")
	public ResponseEntity<Movie> updatemovie(@PathVariable("id") long id, @RequestBody Movie movie)  {
		

		Optional<Movie> movieData = movieRepository.findById(id);

		if (movieData.isPresent()) {
			Movie _movie = movieData.get();
			_movie.setTitle(movie.getTitle());
			_movie.setDescription(movie.getDescription());
			_movie.setReleased(movie.isReleased());
			return new ResponseEntity<>(movieRepository.save(_movie), HttpStatus.OK);
		} else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/movies/{id}")
	public ResponseEntity<HttpStatus> deletemovie(@PathVariable("id") long id) {
		try {
			movieRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/movies")
	public ResponseEntity<HttpStatus> deleteAllmovies() {
		try {
			movieRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/movies/released")
	public ResponseEntity<List<Movie>> findByReleased() {
		try {
			List<Movie> movies = movieRepository.findByReleased(true);

			if (movies.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(movies, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}


