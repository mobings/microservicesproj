package com.cinema.App.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.App.model.Cinema;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {

	List<Cinema> findByMID(long id);

//	Optional<Cinema> findByMovieId(long id);
	
 
}
