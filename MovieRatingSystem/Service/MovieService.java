package com.Technosignia.MovieRatingSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Technosignia.MovieRatingSystem.Entity.Movie;
import com.Technosignia.MovieRatingSystem.Repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;

	public Movie saveMovie(Movie movie)
	{
		
		return movieRepository.save(movie);
	}

	public Movie getMovieById(Long id) 
	{
		
		return movieRepository.findById(id).orElse(null);
	}

	public List<Movie> getAllMovies()
	{
		
		return movieRepository.findAll();
	}

	public Movie updateMovie(Long id, Movie movieDetails) {
		Movie movie=movieRepository.findById(id).orElse(null);
		if(movie!=null)
		{
			movie.setTitle(movieDetails.getTitle());
			movie.setDirector(movieDetails.getDirector());
			movie.setRating(movieDetails.getRating());
			return movieRepository.save(movie);
		}
		else {
		return null;
		}
	}

	public void deleteMovie(Long id) {
	movieRepository.deleteById(id);
		
	}
	
	}
