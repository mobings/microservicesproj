package com.cinema.App.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.App.cinemaexception.Cinemanotfoundexception;
import com.cinema.App.commons.ServiceOneDAO;
import com.cinema.App.model.Cinema;
import com.cinema.App.model.ServiceOneEntity;
import com.cinema.App.repository.CinemaRepository;



@RestController
public class CinemaController {
	
	
	 Logger log = LoggerFactory.getLogger(CinemaController.class);

	@Autowired
	CinemaRepository cinemaRepository;


//	@Value("${movie-service.name}")
	private String name;
	
	
	@GetMapping("/cinemas")
	public ResponseEntity<List<Cinema>> getAllcinemas() {
		try {
			List<Cinema> cinemas = new ArrayList<Cinema>();

		
				cinemaRepository.findAll().forEach(cinemas::add);
			
			

			return new ResponseEntity<>(cinemas, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/cinemas/{id}")
	public ResponseEntity<Cinema> getcinemaById(@PathVariable("id") long id) {
		Optional<Cinema> cinemaData = cinemaRepository.findById(id);

		if (cinemaData.isPresent()) {
			return new ResponseEntity<>(cinemaData.get(), HttpStatus.OK);
		}  else {
			throw new Cinemanotfoundexception("No Cinema with id: " + id);
		}
	}
	
	 @GetMapping("/message")
	    String getMsg() {
	     return  "returning cinema";
	    }
	
	
	
	@GetMapping("/cinemas/movies/{id}")
	
	public List<Cinema> getcinemaByMovieId(@PathVariable("id") long id) {
		log.info("Cinema-Service Called");
		List<Cinema> cinemas = new ArrayList<Cinema>();
		return cinemaRepository.findByMID(id);
				
		
	}
	

	
	
	

	@PostMapping("/cinemas")
	public ResponseEntity<Cinema> createcinema(@RequestBody Cinema cinema) {
		try {
			Cinema _cinema = cinemaRepository
					.save(new Cinema(cinema.getC_name(),cinema.getC_city(),  cinema.getC_start_dat(),
							cinema.getMID(),cinema.getC_boxoffice()
							
		
							
							));
			return new ResponseEntity<>(_cinema, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/cinemas/{id}")
	public ResponseEntity<Cinema> updatecinema(@PathVariable("id") long id, @RequestBody Cinema cinema) {
		Optional<Cinema> cinemaData = cinemaRepository.findById(id);

		if (cinemaData.isPresent()) {
			Cinema _cinema = cinemaData.get();
			_cinema.setC_name(cinema.getC_name());
			_cinema.setC_city(cinema.getC_city());
			_cinema.setC_start_dat(cinema.getC_start_dat());
			_cinema.setC_boxoffice(cinema.getC_boxoffice());
			
			
			
			
			
			
			
			return new ResponseEntity<>(cinemaRepository.save(_cinema), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/cinemas/{id}")
	public ResponseEntity<HttpStatus> deletecinema(@PathVariable("id") long id) {
		try {
			cinemaRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	
	@DeleteMapping("/cinemas")
	public ResponseEntity<HttpStatus> deleteAllcinemas() {
		try {
			cinemaRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	//resilency
	
	@Autowired
	ServiceOneDAO serviceOneDAO;

	@GetMapping("/serviceone-dbdelayed/{serviceId}/{delayMs}")
	//@HystrixCommand
	public ServiceOneEntity getServiceOneInfoDbDelayed(@PathVariable int serviceId, 
			@PathVariable int delayMs) {
		return serviceOneDAO.getById(serviceId, delayMs);
	}
	
//	@GetMapping("/serviceone-hanging")
//	public String getServiceOneHangingCall() {
//		return serviceOneDAO.callHangingService();
//	}
//	
	public ServiceOneEntity returnDummy(Exception e){
		return new ServiceOneEntity(12,"Dummy Data");
	}
	



}
