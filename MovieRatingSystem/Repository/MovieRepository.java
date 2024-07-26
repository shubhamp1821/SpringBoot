package com.Technosignia.MovieRatingSystem.Repository;

import com.Technosignia.MovieRatingSystem.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

}
