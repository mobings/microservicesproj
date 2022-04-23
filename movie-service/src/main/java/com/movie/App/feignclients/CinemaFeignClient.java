package com.movie.App.feignclients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.movie.App.model.Cinema;

import java.util.List;

@FeignClient("zuul-api-gateway")
public interface CinemaFeignClient
{
	@GetMapping("/cinema-service/cinemas/movies/{id}")
    List<Cinema> getcinemaByMovieId(@PathVariable("id") Long id);

}