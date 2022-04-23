package com.movie.App.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.App.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
  List<Movie> findByReleased(boolean released);

  List<Movie> findByTitleContaining(String title);
}
