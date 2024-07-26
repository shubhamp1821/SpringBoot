package com.Technosignia.MovieRatingSystem.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Technosignia.MovieRatingSystem.Entity.Movie;
import com.Technosignia.MovieRatingSystem.Service.MovieService;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@PostMapping
	public Movie createMovie(@RequestBody Movie movie)
	{
		return movieService.saveMovie(movie);	
	}
	
	@GetMapping
	public List<Movie> getAllMovies()
	{
		return movieService.getAllMovies();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Movie> getMovieById(@PathVariable Long id)
	{
		Movie movie=movieService.getMovieById(id);
		if(movie!=null)
		{
			return ResponseEntity.ok(movie);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Movie> updateMovie(@PathVariable Long id,@RequestBody Movie movieDetails)
	{
		Movie updatedMovie=movieService.updateMovie(id,movieDetails);
		if(updatedMovie!=null)
		{
			return ResponseEntity.ok(updatedMovie);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Movie> deleteMovie(@PathVariable Long id)
	{
		movieService.deleteMovie(id);
		return ResponseEntity.noContent().build();
	}
	
}
